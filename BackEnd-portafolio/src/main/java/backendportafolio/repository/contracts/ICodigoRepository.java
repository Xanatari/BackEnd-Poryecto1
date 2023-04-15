package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.CodigoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodigoRepository extends JpaRepository<CodigoEntity, Integer>{
}
