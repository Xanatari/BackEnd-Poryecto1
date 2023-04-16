package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IUserController;
import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.dtos.responses.GenericResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.service.contracts.IUserCredentialService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class UserController implements IUserController {

    private static final Gson gson = new Gson();

    IUserCredentialService iUserCredentialService;

    @Override
    @GetMapping(value = "/credentials")
    public ResponseEntity<Object> getUserCredentials(String email, String password  ) {
        try {
            return new ResponseEntity<>(gson.toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iUserCredentialService.credentialsUser(email , password))
                    .build()),
                    HttpStatus.OK);
        } catch (GenericException e) {
            log.error("Generic exception for loggin user ");
            return new ResponseEntity<>(gson.toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
        }   catch (Exception e ){
            log.error("Error to register the Payer info ");
            return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping(value = "/newUser")
    public ResponseEntity<Object> newUserPlataform(@RequestBody UserRequestDTO userRequestDTO) {
            log.info(" New User Created to the plataform ");

        try {
            return new ResponseEntity<>(gson.toJson(GenericResponse
                        .builder()
                        .rc("0")
                        .msg("OK")
                        .data(iUserCredentialService.createNewUserPlataform(userRequestDTO))
                    .build()),
                    HttpStatus.OK);
        } catch (GenericException e) {
            log.error("Generic exception for create a new user ");
            return new ResponseEntity<>(gson.toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
        }catch (Exception e ){
            log.error("Error to register the estudent info ");
            return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    @PostMapping(value = "/evaluate-code")
    public ResponseEntity<Object> userEvaluateCode(UserRequestDTO userRequestDTO) {
            log.info(" Evaluate code for the user ");

            try {
                return new ResponseEntity<>(gson.toJson(GenericResponse
                        .builder()
                        .rc("0")
                        .msg("OK")
                        .data(iUserCredentialService.createNewUserPlataform(userRequestDTO))
                        .build()),
                        HttpStatus.OK);
            } catch (GenericException e) {
                log.error("Generic exception for create a new user ");
                return new ResponseEntity<>(gson.toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
            }catch (Exception e ){
                log.error("Error to register the\n" +
                        "\n" +
                        "\n Payer info ");
                return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    @Override
    @PostMapping(value = "/generate-user-pdf")
    public ResponseEntity<Object> generateUserPF(@RequestBody UserRequestDTO userRequestDTO) {


            log.info(" New User Created to the plataform ");

            try {
                return new ResponseEntity<>(gson.toJson(GenericResponse
                        .builder()
                        .rc("0")
                        .msg("OK")
                        .data(iUserCredentialService.createNewUserPlataform(userRequestDTO))
                        .build()),
                        HttpStatus.OK);
            } catch (GenericException e) {
                log.error("Generic exception for create a new user ");
                return new ResponseEntity<>(gson.toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
            }catch (Exception e ){
                log.error("Error to register the Payer info ");
                return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
            }
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
