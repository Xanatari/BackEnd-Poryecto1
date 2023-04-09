package backendportafolio.service.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.exceptions.GenericException;
import org.springframework.stereotype.Service;

public interface IUserCredentialService {

    Object createNewUserPlataform(UserRequestDTO userRequestDTO) throws GenericException;
}
