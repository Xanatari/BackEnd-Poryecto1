package backendportafolio.service.implementations;

import backendportafolio.dtos.responses.ResultadosResposne;
import backendportafolio.dtos.responses.ResumenResultadosResponse;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.contracts.IResultadosRepository;
import backendportafolio.service.contracts.IResultadosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        var pruebasEntity = iPruebasRepository.getByEstudianteId(estudianteId);
        var resultadosEntity = iResultadosRepository.getAllByPruebasId(pruebasEntity.get(0).getPruebasid());

        List<ResumenResultadosResponse> resumenResultadosResponses = new ArrayList<>();
        pruebasEntity.forEach(p -> {
            var resul = ResumenResultadosResponse.builder();
            resul.prueba(p.getDescripcionPrueba());
           iResultadosRepository.getAllByPruebasId(p.getPruebasid()).forEach(resuladosEntity -> {
               resul.codigo(resuladosEntity.getCodigoId());
               resul.resultado(resuladosEntity.getResultado());
           });
           resumenResultadosResponses.add(resul.build());
        });

        return null;
    }
}
