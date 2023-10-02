package backendportafolio.service.contracts;

import backendportafolio.dtos.request.CredentialsRequestDTO;
import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.dtos.responses.CredentialsResponse;
import backendportafolio.exceptions.GenericException;


public interface IUserCredentialService {

    Object createNewUserPlataform(UserRequestDTO userRequestDTO) throws GenericException;

    Object evaluatedUserCode(String code) throws GenericException;

    CredentialsResponse credentialsUser(CredentialsRequestDTO credentialsRequestDTO) throws GenericException;
}
