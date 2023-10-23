package backendportafolio.service.contracts;

import backendportafolio.dtos.responses.EspecialidadesResponse;
import backendportafolio.dtos.responses.UserInfoResponse;

import java.util.List;

public interface IUserInfoService {

    List<EspecialidadesResponse> getUserInfo (String tipo);
}
