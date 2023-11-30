package backendportafolio.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EvaluacionSolucionDTO {

    private String codigo;
    private int prueba;

}
