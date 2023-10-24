package backendportafolio.controller.contracts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IEspecialidadesController {

    ResponseEntity<Object> getEspecialidades(String tipo);
    public ResponseEntity<Object> getUserInfo(@PathVariable int estudianteId);
}
