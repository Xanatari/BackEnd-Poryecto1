package backendportafolio.service.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import org.springframework.stereotype.Service;

public interface IUserCredentialService {

    Object createNewUserPlataform(UserRequestDTO userRequestDTO);
}
