package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IPruebasController;
import backendportafolio.dtos.request.PruebasRequest;
import backendportafolio.dtos.responses.GenericResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.service.contracts.IPruebasEstudiantesService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/pruebas")
@Slf4j
@AllArgsConstructor
public class PruebasController implements IPruebasController {

    Gson gson = new Gson();


    IPruebasEstudiantesService iPruebasEstudiantesService;

    @Override
    @GetMapping(value = "/prueba/{estudiantesId}")
    public ResponseEntity<Object> getPruebaEstudiante(@PathVariable int estudiantesId, @RequestBody  PruebasRequest pruebasRequest) {

        log.info(" Generando nueva prueba para el estudiante ID {}", estudiantesId);

        try {
            return new ResponseEntity<>(gson.toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iPruebasEstudiantesService.getPruebasEstudiante(estudiantesId, pruebasRequest))
                    .build()),
                    HttpStatus.OK);
        } catch (GenericException e) {
            log.error("Generic exception for loggin user ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
        } catch (Exception e ){
            log.error("Error to Generate prueba the estudent info ", e);
            return new ResponseEntity<>(gson.toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
