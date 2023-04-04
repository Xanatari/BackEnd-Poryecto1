package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCredentialRepository extends JpaRepository<EstudiantesEntity,Long > {
}
