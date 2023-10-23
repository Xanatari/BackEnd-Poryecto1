package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IEspecialidadesController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/especialidades", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class EspecialidadesController implements IEspecialidadesController {


    @Override
    public ResponseEntity<Object> getEspecialidades(String tipo) {
        return null;
    }
}
