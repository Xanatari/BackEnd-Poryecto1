package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IDocumentManagmentController;
import backendportafolio.service.contracts.IDocumentManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/document-managment")
@Slf4j
@AllArgsConstructor
public class DocumentManagmentController implements IDocumentManagmentController {


    IDocumentManageService documentManageService;

    @Override
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> setImageProfile(int estudiantesId, MultipartFile multipartFile) {
        return null;
    }
}
