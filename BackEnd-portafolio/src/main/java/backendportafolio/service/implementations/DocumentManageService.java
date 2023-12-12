package backendportafolio.service.implementations;

import backendportafolio.integrations.S3DocumentManage;
import backendportafolio.service.contracts.IDocumentManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@AllArgsConstructor
public class DocumentManageService implements IDocumentManageService {

    S3DocumentManage s3DocumentManage;


    @Override
    public void uploadProfileEstudentImage(MultipartFile multipartFile, int userId) throws IOException {
        s3DocumentManage.uploadFile(multipartFile, "tesis-seria-s3", "profile-image/");
    }

    @Override
    public InputStreamResource getProfileEstudentImage(int userId) {

        var file = s3DocumentManage.getFile("tesis-seria-s3","profile-image/", "20201022173043_1.jpg" );

        InputStreamResource inputStreamResource = new InputStreamResource(file);

        return inputStreamResource;
    }


}
