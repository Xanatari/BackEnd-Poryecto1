package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.PruebasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPruebasRepository extends JpaRepository<PruebasEntity, Long> {

    List<PruebasEntity> getByEstudianteId (int estudianteId);
}
