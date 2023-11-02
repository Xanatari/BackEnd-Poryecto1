package backendportafolio.service.contracts;

import backendportafolio.dtos.responses.ResultadosResposne;

import java.util.List;

public interface IResultadosService {

    List<ResultadosResposne> getResultadosByEstudiante (int estudianteId);
}
