package backendportafolio.service.contracts;

import backendportafolio.dtos.responses.ResultadosResposne;
import backendportafolio.dtos.responses.ResumenResultadosResponse;

import java.util.List;

public interface IResultadosService {

    List<ResultadosResposne> getResultadosByEstudiante (int estudianteId);

    List<ResumenResultadosResponse> getResumeResultados(int estudianteId);
}
