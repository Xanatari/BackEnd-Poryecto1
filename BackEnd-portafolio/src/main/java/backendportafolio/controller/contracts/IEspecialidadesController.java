package backendportafolio.controller.contracts;

import org.springframework.http.ResponseEntity;

public interface IEspecialidadesController {

    ResponseEntity<Object> getEspecialidades(String tipo);
}
