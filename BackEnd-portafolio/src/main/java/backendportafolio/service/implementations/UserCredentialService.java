package backendportafolio.service.implementations;

import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.repository.contracts.IRolRepository;
import backendportafolio.repository.contracts.IUserCredentialRepository;
import backendportafolio.repository.entities.EstudiantesEntity;
import backendportafolio.service.contracts.IUserCredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCredentialService implements IUserCredentialService {

    @Autowired
    IUserCredentialRepository iUserCredentialRepository;

    @Autowired
    IRolRepository iRolRepository;

    @Override
    public Object createNewUserPlataform(UserRequestDTO userRequestDTO) {
        log.info("Service Layer create a new user for plataform");

        EstudiantesEntity estudiantesEntity = EstudiantesEntity
                .builder()
                    .nameLastName(userRequestDTO.getName() + userRequestDTO.getLastName())
                    .email(userRequestDTO.getEmail())
                    .rol(userRequestDTO.getRol())
                    .facultad(userRequestDTO.getFacultad())
                    .especialidad(userRequestDTO.getEspecialidad())
                .build();

        iUserCredentialRepository.save(estudiantesEntity);

        return null;
    }
}
