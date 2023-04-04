package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolesEntity,Integer > {
}
