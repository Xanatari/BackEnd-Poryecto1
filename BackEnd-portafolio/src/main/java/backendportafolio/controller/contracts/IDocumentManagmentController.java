package backendportafolio.controller.contracts;

import backendportafolio.dtos.request.EvaluacionSolucionDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDocumentManagmentController {

    ResponseEntity<Object> setImageProfile(int userId, MultipartFile multipartFile);

    ResponseEntity<InputStreamResource> getImagePro9file(int userId) throws IOException;
}
