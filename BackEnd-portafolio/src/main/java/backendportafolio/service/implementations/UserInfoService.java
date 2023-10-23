package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.EspecialidadesResponse;
import backendportafolio.dtos.responses.UserInfoResponse;
import backendportafolio.repository.contracts.IEspecialidadesEstudiantes;
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

    IEspecialidadesEstudiantes iEspecialidadesEstudiantes;

    @Override
    public List<EspecialidadesResponse> getUserInfo(String tipo) {
        log.info("Try to get estudent info for id {}", tipo );

        var userInfo = iEspecialidadesEstudiantes.findAllByTipo(tipo);

        List<EspecialidadesResponse> listEspecialidades = new ArrayList<>();

        return null;
    }
}
