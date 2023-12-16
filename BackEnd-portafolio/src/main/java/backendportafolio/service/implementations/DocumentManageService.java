package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.ResumenResultadosResponse;
import backendportafolio.integrations.S3DocumentManage;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.contracts.IResultadosRepository;
import backendportafolio.repository.entities.PruebasEntity;
import backendportafolio.service.contracts.IDocumentManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import static javax.swing.text.StyleConstants.LineSpacing;

@Service
@Slf4j
@AllArgsConstructor
public class DocumentManageService implements IDocumentManageService {

    S3DocumentManage s3DocumentManage;
    private final S3Client s3Client;
    IPruebasRepository iPruebasRepository;
    IResultadosRepository iResultadosRepository;

    @Override
    public void uploadProfileEstudentImage(MultipartFile multipartFile, int userId) throws IOException {
        s3DocumentManage.uploadFile(multipartFile, "tesis-seria-s3", "profile-image/");
    }

    @Override
    public byte[] getProfileEstudentImage(int userId) throws IOException {
        XWPFDocument document = new XWPFDocument();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String[] lineas = retroAlimentacion(userId).split("\n");

        for (String linea : lineas) {

            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.BOTH); // Adjust alignment if needed
            paragraph.setSpacingAfter(24);

            XWPFRun run = paragraph.createRun();
            run.setFontSize(12); // Adjust font size if needed
            run.setFontFamily("Calibri"); // Adjust font family if needed
            run.setText(linea);
        }

        document.write(outputStream);
        outputStream.close();

        String filename = "feedback_" + userId + ".docx";
        s3Client.putObject(PutObjectRequest.builder()
                .bucket("tesis-seria-s3")
                .key("profile-image/" + filename)
                .build(), RequestBody.fromBytes(outputStream.toByteArray()));

        return s3DocumentManage.getFile("tesis-seria-s3", "profile-image/", filename);
    }

    private String retroAlimentacion(int estudianteId){
        var resume = getResumeResultados( estudianteId);
        final String[] resumenPDF = {"Buenos dias acontinuacion te dejo un resumen de todas las pruebas y retroalimentacion que has tenido de las pruebas que has echo con la app: \n"};
        resume.forEach(resumenResultadosResponse -> {
            String prueba = "Prueba : " + resumenResultadosResponse.getPrueba() +"\n"
                    +"_________________________________________";
            String codigo = "Solucion que propusiste: " + resumenResultadosResponse.getCodigo() + "\n"
                    +"_________________________________________";

            String resultado = "Solucion que propusiste: " + resumenResultadosResponse.getResultado() + "\n"
                    +"_________________________________________";

            resumenPDF[0] += prueba + codigo + resultado;
        });

        return resumenPDF[0];
    }


    private List<ResumenResultadosResponse> getResumeResultados(int estudianteId) {
        List<PruebasEntity> pruebasEntityList = iPruebasRepository.getByEstudianteId(estudianteId);

        return pruebasEntityList.stream()
                .map(prueba -> {
                    ResumenResultadosResponse.ResumenResultadosResponseBuilder resul = ResumenResultadosResponse.builder()
                            .prueba(prueba.getContenido());

                    iResultadosRepository.getAllByPruebasId(prueba.getPruebasid())
                            .forEach(resultadosEntity -> {
                                resul.codigo(resultadosEntity.getCodigoId())
                                        .resultado(resultadosEntity.getResultado());
                            });

                    return resul.build();
                })
                .collect(Collectors.toList());

    }


}
