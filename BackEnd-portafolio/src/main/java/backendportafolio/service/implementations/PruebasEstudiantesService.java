package backendportafolio.service.implementations;


import backendportafolio.config.OpenIA.ChatGPTRequest;
import backendportafolio.config.OpenIA.ChatWithOpenIA;
import backendportafolio.dtos.request.EvaluacionSolucionDTO;
import backendportafolio.dtos.request.PruebasRequest;
import backendportafolio.dtos.responses.PruebasResponse;
import backendportafolio.dtos.responses.ResultEvaluacionResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.repository.contracts.IEstudiantesRepository;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.contracts.IResultadosRepository;
import backendportafolio.repository.entities.PruebasEntity;
import backendportafolio.repository.entities.ResuladosEntity;
import backendportafolio.service.contracts.IPruebasEstudiantesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PruebasEstudiantesService implements IPruebasEstudiantesService {

    IPruebasRepository iPruebasRepository;
    IEstudiantesRepository iEstudiantesRepository;
    ChatWithOpenIA chatWithOpenIA;
    IResultadosRepository iResultadosRepository;

    @Override
    public PruebasResponse getPruebasEstudiante(int estudianteId, PruebasRequest pruebasRequest) throws GenericException {
        log.info("Try to get estudent info for id {}", estudianteId );
       iEstudiantesRepository.findById(estudianteId).orElseThrow(()->new GenericException("Estudiante no encontrado "));

       String response =  chatWithOpenIA.chatWithGTP(getPromtGTP(pruebasRequest.getHabilidades(), pruebasRequest.getTecnologiasLenguajes()));

       String resume = resume(pruebasRequest.getHabilidades(), pruebasRequest.getTecnologiasLenguajes()) ;

       PruebasEntity pruebasEntity = new PruebasEntity();
       pruebasEntity.setEstudianteId(estudianteId);
       pruebasEntity.setContenido(response);
       pruebasEntity.setDescripcionPrueba(resume);
       pruebasEntity.setComplegidad(pruebasRequest.getHabilidades());
       pruebasEntity.setEspecialidad(pruebasRequest.getTecnologiasLenguajes());


       iPruebasRepository.save(pruebasEntity);

        return PruebasResponse.builder()
                .pruebaTecnica(response)
                .build();
    }

    @Override
    public ResultEvaluacionResponse setEvaluacionSolucion(int estudianteId, EvaluacionSolucionDTO evaluacionCodigoDTO) throws GenericException {

        log.info("Try to get estudent info for id {}", estudianteId );
        iEstudiantesRepository.findById(estudianteId).orElseThrow(()->new GenericException("Estudiante no encontrado "));

        var prueba = iPruebasRepository.findById((long) evaluacionCodigoDTO.getPruebaId()).orElseThrow(() ->  new GenericException("Estudiante no encontrado "));

        String response =  chatWithOpenIA.chatWithGTP(getPromtToEvaluateSolution( prueba.getContenido(), evaluacionCodigoDTO.getCodigo()));

        ResuladosEntity resuladosEntity = new ResuladosEntity();

        resuladosEntity.setPruebasId(evaluacionCodigoDTO.getPruebaId());
        resuladosEntity.setCodigoId(evaluacionCodigoDTO.getCodigo());
        resuladosEntity.setResultado(response);



        return ResultEvaluacionResponse.builder()
                .resultadoEvaluacion(response)
                .build();
    }

    private String getPromtGTP(String habilidad , String tecnologiaLenguajes ){
        String promptToGTP = "Prudes generarme una pregunta o reto de programacion que incluya los siguientes temas al respecto, principalmente una combinacion entre ${TECHANDHABILITIES}$ y ${HABILIDADES}$ , que prueba técnica puedo ponerle a un estudiante de ingeniería de sistemas";

        promptToGTP = promptToGTP.replace("${TECHANDHABILITIES}$", tecnologiaLenguajes)
                                 .replace("${HABILIDADES}$", habilidad);

        return promptToGTP;


    }

    private String resume(String habilidad , String tecnologiaLenguajes ) {
        String resume = "Prueba tecnica sencilla entre ${TECHANDHABILITIES}$ y ${HABILIDADES}$";

        resume = resume.replace("${TECHANDHABILITIES}$", tecnologiaLenguajes)
                       .replace("${HABILIDADES}$", habilidad);

        return resume;


    }

    private String getPromtToEvaluateSolution(String pregunta , String solucion ){
        String promptToGTP = "Esta es la pregunta que me formulaste " + pregunta+ ", ahora esta es la siguiente solucion a esa pregunta" +
             solucion + ", me puedes decir tu opinion al respecto de la solucion que plateo ? ";

        return promptToGTP;


    }
}
