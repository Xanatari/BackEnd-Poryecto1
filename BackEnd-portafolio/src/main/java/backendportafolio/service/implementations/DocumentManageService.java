package backendportafolio.service.implementations;

import backendportafolio.integrations.S3DocumentManage;
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

@Service
@Slf4j
@AllArgsConstructor
public class DocumentManageService implements IDocumentManageService {

    S3DocumentManage s3DocumentManage;
    private final S3Client s3Client;

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
            // Agrega contenido a la página según tus necesidades
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Contenido dinámico dsafdsafsdfasdfasdfsadfasdfasdfasdfasdfasdfasdfasdf");
            contentStream.endText();
        }

        document.save(outputStream);
        document.close();

        s3Client.putObject(PutObjectRequest.builder()
                .bucket("tesis-seria-s3")
                .key("profile-image/Hoja-membrete-carta-color.pdf")
                .build(), RequestBody.fromBytes(outputStream.toByteArray()));

        return s3DocumentManage.getFile("tesis-seria-s3","profile-image/", "Hoja-membrete-carta-color.pdf" );
    }


}
