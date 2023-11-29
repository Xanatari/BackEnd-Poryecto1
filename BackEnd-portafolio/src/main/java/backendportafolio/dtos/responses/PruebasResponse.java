package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class PruebasResponse {

    private String pruebaTecnica;
    private int pruebaId;
}
