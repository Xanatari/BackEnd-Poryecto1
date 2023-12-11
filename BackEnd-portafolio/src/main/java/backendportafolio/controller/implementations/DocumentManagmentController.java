package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IDocumentManagmentController;
import backendportafolio.service.contracts.IDocumentManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/document-managment")
@Slf4j
@AllArgsConstructor
public class DocumentManagmentController implements IDocumentManagmentController {


    IDocumentManageService documentManageService;

    @Override
    @PostMapping(value = "/image-profile/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> setImageProfile(@PathVariable int userId, @RequestParam("file") MultipartFile multipartFile) {

        try {
            documentManageService.uploadProfileEstudentImage(multipartFile, userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
