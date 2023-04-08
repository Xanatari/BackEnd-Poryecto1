package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IUserController;
import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.dtos.responses.GenericResponse;
import backendportafolio.service.contracts.IUserCredentialService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController implements IUserController {

    private static final Gson gson = new Gson();

    @Autowired
    IUserCredentialService iUserCredentialService;

    @Override
    @GetMapping(value = "/credentials")
    public ResponseEntity<Object> getUserCredentials() {
        log.info("Get User Credentials for loggin ");

        return new ResponseEntity<>(gson.toJson(GenericResponse
                .builder()
                     .rc("0")
                     .msg("OK").data(null).build()), HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/newUser")
    public ResponseEntity<Object> newUserPlataform(@RequestBody UserRequestDTO userRequestDTO) {
            log.info(" New User Created to the plataform ");

            return new ResponseEntity<>(gson.toJson(GenericResponse
                        .builder()
                        .rc("0")
                        .msg("OK")
                        .data(iUserCredentialService.createNewUserPlataform(userRequestDTO))
                    .build()),
                    HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> userEvaluateCode() {
        return null;
    }

    @Override
    public ResponseEntity<Object> generateUserPF() {
        return null;
    }

    @Override
    public ResponseEntity<Object> userHabilities() {
        return null;
    }

    @Override
    public ResponseEntity<Object> userTopicEvaluate() {
        return null;
    }

    @Override
    public ResponseEntity<Object> userInfo() {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateUserEvaluates() {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateTopicsEvaluate() {
        return null;
    }
}
