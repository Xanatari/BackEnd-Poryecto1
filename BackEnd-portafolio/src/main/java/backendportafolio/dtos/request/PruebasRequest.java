package backendportafolio.dtos.request;

import com.mysql.cj.exceptions.StreamingNotifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PruebasRequest {

    private String tecnologiasLenguajes;

    private String habilidades;
}
