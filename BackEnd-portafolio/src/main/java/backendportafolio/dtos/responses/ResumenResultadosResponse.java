package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class ResumenResultadosResponse {

    private String prueba;
    private String codigo;
    private String resultado;
}
