package backendportafolio.repository.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEstudiantesRepository extends JpaRepository<EstudiantesEntity, Integer> {

    Optional<EstudiantesEntity> findByEmail (String email );
}
