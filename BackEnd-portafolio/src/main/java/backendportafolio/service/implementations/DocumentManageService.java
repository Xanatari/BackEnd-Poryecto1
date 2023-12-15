package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.ResumenResultadosResponse;
import backendportafolio.integrations.S3DocumentManage;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.contracts.IResultadosRepository;
import backendportafolio.repository.entities.PruebasEntity;
import backendportafolio.service.contracts.IDocumentManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ResponseInputStream<GetObjectResponse> s3Object = s3Client.getObject(GetObjectRequest.builder()
                .bucket("tesis-seria-s3")
                .key("profile-image/Hoja-membrete-carta-color.pdf")
                .build());
        PDDocument document = PDDocument.load(s3Object);
        PDPage page = document.getPage(0);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            // Agrega contenido a la página según tus necesidades
            String[] lineas = retroAlimentacion(userId).split("\n");

            // Establecer la posición inicial
            float yPosition = 650;

            for (String linea : lineas) {
                // Agregar texto a la página
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText(linea);
                contentStream.endText();

                // Mover a la siguiente línea
                yPosition -= 15; // Ajusta según sea necesario
            }
        }

        document.save(outputStream);
        document.close();

        s3Client.putObject(PutObjectRequest.builder()
                .bucket("tesis-seria-s3")
                .key("profile-image/Hoja-membrete-carta-color.pdf")
                .build(), RequestBody.fromBytes(outputStream.toByteArray()));

        return s3DocumentManage.getFile("tesis-seria-s3","profile-image/", "Hoja-membrete-carta-color.pdf" );
    }

    private String retroAlimentacion(int estudianteId){
        var resume = getResumeResultados( estudianteId);
        final String[] resumenPDF = {"Buenos dias acontinuacion te dejo un resumen de todas las pruebas y retroalimentacion que has tenido de las pruebas que has echo con la app: \n"};
        resume.forEach(resumenResultadosResponse -> {
            String prueba = "Prueba : " + resumenResultadosResponse.getPrueba() +"\n"
                    +"_________________________________________________________________________________________";
            String codigo = "Solucion que propusiste: " + resumenResultadosResponse.getCodigo() + "\n"
                    +"_________________________________________________________________________________________";

            String resultado = "Solucion que propusiste: " + resumenResultadosResponse.getResultado() + "\n"
                    +"_________________________________________________________________________________________";

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
