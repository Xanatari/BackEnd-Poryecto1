package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class GenericResponse {

    private String rc;
    private String msg;
    private Object data;

    public GenericResponse(String rc, String msg, Object data) {
        this.rc = rc;
        this.msg = msg;
        this.data = data;
    }
}
