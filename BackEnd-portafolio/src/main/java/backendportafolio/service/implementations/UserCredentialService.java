package backendportafolio.service.implementations;

import backendportafolio.dtos.request.CredentialsRequestDTO;
import backendportafolio.dtos.request.UserRequestDTO;
import backendportafolio.dtos.responses.CredentialsResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.repository.contracts.ICodigoRepository;
import backendportafolio.repository.contracts.IEstudiantesRepository;
import backendportafolio.repository.contracts.IRolRepository;
import backendportafolio.repository.contracts.IUserCredentialRepository;
import backendportafolio.service.contracts.IUserCredentialService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserCredentialService implements IUserCredentialService {

    IUserCredentialRepository iUserCredentialRepository;
    IEstudiantesRepository iEstudiantesRepository;
    IRolRepository iRolRepository;
    ICodigoRepository iCodigoRepository;




    @Override
    public Object createNewUserPlataform(UserRequestDTO userRequestDTO) throws GenericException {
        log.info("Service Layer create a new user for plataform");

        if (!iEstudiantesRepository.findByEmail(userRequestDTO.getEmail()).isEmpty()){
           throw new GenericException("El usuario que se quiere registrar ya se registo en la plataforma");
        }

        var estudiantesEntity = new EstudiantesEntity();
           estudiantesEntity.setNameLastName(userRequestDTO.getName() + userRequestDTO.getLastName());
           estudiantesEntity.setEmail(userRequestDTO.getEmail());
           estudiantesEntity.setRol(userRequestDTO.getRol());
           estudiantesEntity.setFacultad(userRequestDTO.getFacultad());
           estudiantesEntity.setEspecialidad(userRequestDTO.getEspecialidad());
           estudiantesEntity.setIdCredenciales(Base64.getEncoder().encodeToString(userRequestDTO.getPassword().getBytes()));


        iUserCredentialRepository.save(estudiantesEntity);

        return null;
    }

    @Override
    public Object evaluatedUserCode(String code) throws GenericException {
        log.info("Service Layer evaluated user code");

        return null;
    }

    @Override
    public CredentialsResponse credentialsUser(CredentialsRequestDTO credentialsRequestDTO) throws GenericException {

        if (!iEstudiantesRepository.findByEmail(credentialsRequestDTO.getUserName()).isPresent()){
            throw new GenericException("El usuario que se quiere ingresar no se encuantra registrado en la plataforma");
        }
        Optional<EstudiantesEntity> estudiantesEntity = iEstudiantesRepository.findByEmail(credentialsRequestDTO.getUserName());

       CredentialsResponse credentialsResponse = CredentialsResponse.builder()
                .userId(String.valueOf(estudiantesEntity.get().getEstudiantesId()))
                .sessionToken(generateToken( estudiantesEntity.get().getEmail() + estudiantesEntity.get().getNameLastName()))
                .rol(estudiantesEntity.get().getRol())
                .build();

        return credentialsResponse;
    }

    private String generateToken(String sesionToken){
        Base64.Encoder encoder = Base64.getEncoder();
        String encoded = encoder.encodeToString(sesionToken.getBytes());
        return encoded;
    }
}
