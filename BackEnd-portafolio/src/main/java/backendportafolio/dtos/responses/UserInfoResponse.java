package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class UserInfoResponse {

    private String nameLastName;
    private String facultad;
    private String espacialidad;


}
