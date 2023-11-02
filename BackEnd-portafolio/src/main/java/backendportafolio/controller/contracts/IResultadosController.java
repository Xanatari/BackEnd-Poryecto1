package backendportafolio.controller.contracts;

import org.springframework.http.ResponseEntity;

public interface IResultadosController {

    ResponseEntity<Object> getPruebasAndResultados(int userId);
}
