package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.EspecialidadesResponse;
import backendportafolio.dtos.responses.UserInfoResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.repository.contracts.IEspecialidadesEstudiantesRepository;
import backendportafolio.repository.contracts.IEstudiantesRepository;
import backendportafolio.service.contracts.IUserInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserInfoService implements IUserInfoService {

    IEspecialidadesEstudiantesRepository iEspecialidadesEstudiantes;
    IEstudiantesRepository iEstudiantesRepository;

    @Override
    public List<EspecialidadesResponse> getHabilitiesByType(String tipo) throws GenericException{
        log.info("Try to get habilities {}", tipo );

        var userInfo = iEspecialidadesEstudiantes.findAllByTipo(tipo);

        if (userInfo.isEmpty()){
            throw  new GenericException("EL tipo no esta encontrado ");
        }
        List<EspecialidadesResponse> listEspecialidades = new ArrayList<>();
        userInfo.get().forEach(especialidadesEntity -> {
            listEspecialidades.add(   EspecialidadesResponse
                    .builder()
                        .id(especialidadesEntity.getEspecialidadesId())
                        .tipo(especialidadesEntity.getTipo())
                        .nombre(especialidadesEntity.getNombre())
                        .descripcion(especialidadesEntity.getDescripcion())
                    .build());
        });


        return listEspecialidades;
    }

    @Override
    public UserInfoResponse getUserInfo(int userId) throws GenericException {
        log.info("Try to get estudent info for id {}", userId );
        var infoEstudiantes = iEstudiantesRepository.findById(userId);

        if (infoEstudiantes.isEmpty()){
            throw  new GenericException("Estudiante no encontrado ");
        }
        return UserInfoResponse
                .builder()
                .nameLastName(infoEstudiantes.get().getNameLastName())
                .espacialidad(infoEstudiantes.get().getEspecialidad())
                .facultad(infoEstudiantes.get().getFacultad())
                .build();
    }
}
