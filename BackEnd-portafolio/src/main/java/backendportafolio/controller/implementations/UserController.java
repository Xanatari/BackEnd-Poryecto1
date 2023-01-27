package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IUserController;
import backendportafolio.dtos.responses.GenericResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController implements IUserController {

    private static final Gson gson = new Gson();

    @Override
    @GetMapping(value = "/credentials")
    public ResponseEntity<Object> getUserCredentials() {
        log.info("Get User Credentials for loggin ");

        return new ResponseEntity<>(gson.toJson(GenericResponse
                .builder()
                     .rc("0")
                     .msg("OK").data(null).build()), HttpStatus.OK);
    }
}
