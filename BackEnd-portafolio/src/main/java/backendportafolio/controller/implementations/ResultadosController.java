package backendportafolio.controller.implementations;

import backendportafolio.controller.contracts.IResultadosController;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/resusltados")
@Slf4j
@AllArgsConstructor
public class ResultadosController implements IResultadosController {

    Gson gson ;

    @GetMapping(value = "/resultados")
    @Override
    public ResponseEntity<Object> getPruebasAndResultados(int userId) {
        return null;
    }
}
