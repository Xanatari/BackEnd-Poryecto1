package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.PruebasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPruebasRepository extends JpaRepository<PruebasEntity, Long> {

    PruebasEntity getPruebasEntityByEstudianteId(int estudianteId);
}
