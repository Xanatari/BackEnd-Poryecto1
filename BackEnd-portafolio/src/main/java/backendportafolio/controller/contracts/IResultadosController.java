package backendportafolio.controller.contracts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IResultadosController {

    ResponseEntity<Object> getPruebasAndResultados(int userId);
    public ResponseEntity<Object> getResumePruebasAndResultados( int userId);
}
