package backendportafolio.dtos.responses;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.xml.stream.events.StartElement;

@Builder
@EqualsAndHashCode
public class ResultEvaluacionResponse {

    private String resultadoEvaluacion;
}
