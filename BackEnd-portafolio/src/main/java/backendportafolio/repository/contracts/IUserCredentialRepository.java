package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.EstudiantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCredentialRepository extends JpaRepository<EstudiantesEntity,Integer > {
}
