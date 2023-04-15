package backendportafolio.service.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.dtos.responses.CredentialsResponse;
import backendportafolio.exceptions.GenericException;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.stereotype.Service;

public interface IUserCredentialService {

    Object createNewUserPlataform(UserRequestDTO userRequestDTO) throws GenericException;

    Object evaluatedUserCode(String code) throws GenericException;

    CredentialsResponse credentialsUser(String email, String password) throws GenericException;
}
