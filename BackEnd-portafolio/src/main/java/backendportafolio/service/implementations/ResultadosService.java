package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.ResultadosResposne;
import backendportafolio.service.contracts.IResultadosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ResultadosService implements IResultadosService {



    @Override
    public List<ResultadosResposne> getResultadosByEstudiante(int estudianteId) {
        return null;
    }
}
