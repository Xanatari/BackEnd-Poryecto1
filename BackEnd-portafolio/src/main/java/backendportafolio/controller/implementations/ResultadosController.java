package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IResultadosController;
import backendportafolio.dtos.responses.GenericResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.service.contracts.IResultadosService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/resusltados")
@Slf4j
@AllArgsConstructor
public class ResultadosController implements IResultadosController {

    Gson gson ;
    IResultadosService iResultadosService;

    @GetMapping(value = "/resultados/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    @Override
    public ResponseEntity<Object> getPruebasAndResultados(@PathVariable int userId) {
        try {
            return new ResponseEntity<>(new Gson().toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iResultadosService.getResultadosByEstudiante(userId))
                    .build()),
                    HttpStatus.OK);
        } catch (Exception e ){
            log.error("Error to register the Payer info ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/resultados/{userId}/resume")
    @CrossOrigin(origins = "http://localhost:3000")
    @Override
    public ResponseEntity<Object> getResumePruebasAndResultados(@PathVariable int userId) {
        try {
            return new ResponseEntity<>(new Gson().toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iResultadosService.getResumeResultados(userId))
                    .build()),
                    HttpStatus.OK);
        } catch (Exception e ){
            log.error("Error to register the Payer info ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
