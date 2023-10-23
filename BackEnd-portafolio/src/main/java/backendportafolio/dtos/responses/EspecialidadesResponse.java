package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class EspecialidadesResponse {

    private int id;
    private String nombre;
    private String tipo;
    private String descripcion;
}
