package backendportafolio.service.implementations;

import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.exceptions.GenericException;
import backendportafolio.repository.contracts.IEstudiantesRepository;
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
    IEstudiantesRepository iEstudiantesRepository;

    @Autowired
    IRolRepository iRolRepository;

    @Override
    public Object createNewUserPlataform(UserRequestDTO userRequestDTO) throws Exception {
        log.info("Service Layer create a new user for plataform");

        if (!iEstudiantesRepository.findByEmail(userRequestDTO.getEmail()).isPresent()){
            throw new GenericException("El usuario que se quiere registrar ya se registo en la plataforma");
        }

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
