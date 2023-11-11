package backendportafolio.repository.contracts;

import backendportafolio.repository.entities.ResuladosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResultadosRepository extends JpaRepository<ResuladosEntity, Long> {

    List<ResuladosEntity> getAllByPruebasId(int pruebasId);
}
