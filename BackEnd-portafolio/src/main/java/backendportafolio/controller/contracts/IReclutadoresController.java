package backendportafolio.controller.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IReclutadoresController {


    ResponseEntity<Object> getUserCredentials(String email, String password);

    //Post Methods
    ResponseEntity <Object> newUserPlataform(UserRequestDTO userRequestDTO);

    ResponseEntity <Object> userEvaluateCode(UserRequestDTO userRequestDTO);

    ResponseEntity <Object> generateUserPF(UserRequestDTO userRequestDTO);

    //Get meThods
    ResponseEntity <Object> userHabilities();

    ResponseEntity <Object> userTopicEvaluate();

    ResponseEntity <Object> userInfo();
}
