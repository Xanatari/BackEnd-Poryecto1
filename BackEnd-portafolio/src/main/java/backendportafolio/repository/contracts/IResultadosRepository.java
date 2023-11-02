package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.ResuladosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultadosRepository extends JpaRepository<ResuladosEntity, Long> {
}
