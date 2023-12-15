package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Data
public class ResumenResultadosResponse {

    private String prueba;
    private String codigo;
    private String resultado;
}
