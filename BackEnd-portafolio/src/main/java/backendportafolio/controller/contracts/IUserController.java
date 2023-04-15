package backendportafolio.controller.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IUserController {

    ResponseEntity <Object> getUserCredentials();

    //Post Methods
    ResponseEntity <Object> newUserPlataform(UserRequestDTO userRequestDTO);

    ResponseEntity <Object> userEvaluateCode(UserRequestDTO userRequestDTO);

    ResponseEntity <Object> generateUserPF(UserRequestDTO userRequestDTO);

    //Get meThods
    ResponseEntity <Object> userHabilities();

    ResponseEntity <Object> userTopicEvaluate();

    ResponseEntity <Object> userInfo();


    //Put Methods

    ResponseEntity <Object> updateUserEvaluates();

    ResponseEntity <Object> updateTopicsEvaluate();

}
