package backendportafolio.controller.contracts;

import backendportafolio.dtos.request.EvaluacionSolucionDTO;
import backendportafolio.dtos.request.PruebasRequest;
import org.springframework.http.ResponseEntity;

public interface IPruebasController {

    ResponseEntity<Object> getPruebaEstudiante(int estudiantesId, PruebasRequest pruebasRequest);

    ResponseEntity<Object> setEvaluacionResultado(int estudiantesId, EvaluacionSolucionDTO evaluacionCodigoDTO);
}
