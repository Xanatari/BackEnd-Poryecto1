package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.EspecialidadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEspecialidadesEstudiantesRepository extends JpaRepository <EspecialidadesEntity, Integer> {

    Optional<List<EspecialidadesEntity>> findAllByTipo(String tipo);
}
