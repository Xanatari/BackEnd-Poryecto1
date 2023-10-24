package backendportafolio.service.contracts;

import backendportafolio.dtos.responses.EspecialidadesResponse;
import backendportafolio.dtos.responses.UserInfoResponse;
import backendportafolio.exceptions.GenericException;

import java.util.List;

public interface IUserInfoService {

    List<EspecialidadesResponse> getHabilitiesByType(String tipo) throws GenericException;

    UserInfoResponse getUserInfo(int userId) throws GenericException;

}
