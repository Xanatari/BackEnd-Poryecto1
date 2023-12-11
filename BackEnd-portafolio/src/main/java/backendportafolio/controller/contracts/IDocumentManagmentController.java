package backendportafolio.controller.contracts;

import backendportafolio.dtos.request.EvaluacionSolucionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IDocumentManagmentController {

    ResponseEntity<Object> setImageProfile(int estudiantesId, MultipartFile multipartFile);
}
