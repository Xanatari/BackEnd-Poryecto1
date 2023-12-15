package backendportafolio.service.contracts;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDocumentManageService {

    void uploadProfileEstudentImage(MultipartFile multipartFile, int userId) throws IOException;

    byte[] getProfileEstudentImage(int userId) throws IOException;

}
