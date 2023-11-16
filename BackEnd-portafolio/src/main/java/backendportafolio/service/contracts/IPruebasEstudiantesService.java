package backendportafolio.service.contracts;

import backendportafolio.dtos.request.PruebasRequest;
import backendportafolio.dtos.responses.PruebasResponse;
import backendportafolio.exceptions.GenericException;

public interface IPruebasEstudiantesService {

    PruebasResponse getPruebasEstudiante(int estudianteId, PruebasRequest pruebasRequest) throws GenericException;
}
