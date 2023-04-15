package backendportafolio.dtos.responses;


import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class CredentialsResponse {

    private String userId;
    private String sessionToken;
    private String rol;
}
