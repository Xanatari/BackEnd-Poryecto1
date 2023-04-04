package backendportafolio.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String facultad;

    private  String rol;
    private String especialidad;
}
