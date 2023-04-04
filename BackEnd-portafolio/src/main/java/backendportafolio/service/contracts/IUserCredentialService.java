package backendportafolio.service.contracts;

import backendportafolio.dtos.request.UserRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface IUserCredentialService {

    void createNewUserPlataform(UserRequestDTO userRequestDTO);
}
