package backendportafolio.service.implementations;


import backendportafolio.config.OpenIA.ChatGPTRequest;
import backendportafolio.config.OpenIA.ChatWithOpenIA;
import backendportafolio.dtos.request.PruebasRequest;
import backendportafolio.dtos.responses.PruebasResponse;
import backendportafolio.exceptions.GenericException;
import backendportafolio.repository.contracts.IEstudiantesRepository;
import backendportafolio.repository.contracts.IPruebasRepository;
import backendportafolio.repository.entities.PruebasEntity;
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

    @Override
    public PruebasResponse getPruebasEstudiante(int estudianteId, PruebasRequest pruebasRequest) throws GenericException {
        log.info("Try to get estudent info for id {}", estudianteId );
        var infoEstudiantes = iEstudiantesRepository.findById(estudianteId);

        if (infoEstudiantes.isEmpty()){
            throw  new GenericException("Estudiante no encontrado ");
        }

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

    private String getPromtGTP(String habilidad , String tecnologiaLenguajes ){
        String promtToGTP = "Prudes generarme una pregunta o reto de programacion que incluya los siguientes temas al repecto, principalmente una combinacion entre ${TECHANDHABILITIES}$ y ${HABILIDADES}$ , que prueba tecnica puedo ponerle a un estudiante de ingenieria de sistemas";

        promtToGTP.replace("${TECHANDLENGUAJES}$",tecnologiaLenguajes );
        promtToGTP.replace("${HABILIDADES}$", habilidad);

        return  promtToGTP;

    }

    private String resume(String habilidad , String tecnologiaLenguajes ) {
        String resume = "Prueba tecnica sencilla entre ${TECHANDHABILITIES}$ y ${HABILIDADES}$";
        resume.replace("${TECHANDLENGUAJES}$",tecnologiaLenguajes );
        resume.replace("${HABILIDADES}$", habilidad);

        return  resume;


    }
}
