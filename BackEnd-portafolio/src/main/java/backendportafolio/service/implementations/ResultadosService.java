package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.ResultadosResposne;
import backendportafolio.dtos.responses.ResumenResultadosResponse;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.contracts.IResultadosRepository;
import backendportafolio.repository.entities.PruebasEntity;
import backendportafolio.service.contracts.IResultadosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ResultadosService implements IResultadosService {


    IResultadosRepository iResultadosRepository;
    IPruebasRepository iPruebasRepository;

    @Override
    public List<ResultadosResposne> getResultadosByEstudiante(int estudianteId) {

        var pruebasEntity = iPruebasRepository.getByEstudianteId(estudianteId);

        var resultadosEntity = iResultadosRepository.getAllByPruebasId(pruebasEntity.get(0).getPruebasid());

        List<ResultadosResposne> resultadosResposnes = new ArrayList<>();

        resultadosEntity.forEach(resuladosEntity -> resultadosResposnes.add(ResultadosResposne
                .builder()
                .resultado(resuladosEntity.getResultado())
                .build()));

        return resultadosResposnes;
    }

    @Override
    public List<ResumenResultadosResponse> getResumeResultados(int estudianteId) {
        List<PruebasEntity> pruebasEntityList = iPruebasRepository.getByEstudianteId(estudianteId);

        return pruebasEntityList.stream()
                .map(prueba -> {
                    ResumenResultadosResponse.ResumenResultadosResponseBuilder resul = ResumenResultadosResponse.builder()
                            .prueba(prueba.getContenido());

                    iResultadosRepository.getAllByPruebasId(prueba.getPruebasid())
                            .forEach(resultadosEntity -> {
                                resul.codigo(resultadosEntity.getCodigoId())
                                        .resultado(resultadosEntity.getResultado());
                            });

                    return resul.build();
                })
                .collect(Collectors.toList());

    }
}
