package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IEspecialidadesController;
import backendportafolio.dtos.responses.GenericResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.service.contracts.IUserInfoService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/especialidades", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class EspecialidadesController implements IEspecialidadesController {

    Gson gson ;

    IUserInfoService iUserInfoService;

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{tipo}")
    public ResponseEntity<Object> getEspecialidades(@PathVariable String tipo) {
        try {
            return new ResponseEntity<>(new Gson().toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iUserInfoService.getHabilitiesByType(tipo))
                    .build()),
                    HttpStatus.OK);
        } catch (GenericException e) {
            log.error("Generic exception for get Especialidad type ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
        }   catch (Exception e ){
            log.error("Error to register the Payer info ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/estudent-info/{estudianteId}")
    public ResponseEntity<Object> getUserInfo(@PathVariable int estudianteId) {
        try {
            return new ResponseEntity<>(new Gson().toJson(GenericResponse
                    .builder()
                    .rc("0")
                    .msg("OK")
                    .data(iUserInfoService.getUserInfo(
                            estudianteId))
                    .build()),
                    HttpStatus.OK);
        } catch (GenericException e) {
            log.error("Generic exception for get Especialidad type ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException(e.getMessage())), HttpStatus.BAD_REQUEST);
        }   catch (Exception e ){
            log.error("Error to register the Payer info ");
            return new ResponseEntity<>(new Gson().toJson(new GenericException("Have error plis try again")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
