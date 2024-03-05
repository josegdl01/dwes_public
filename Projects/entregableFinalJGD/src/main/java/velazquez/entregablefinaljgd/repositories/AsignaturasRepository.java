package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez.entregablefinaljgd.models.Asignatura;
import velazquez.entregablefinaljgd.models.Profesor;

import java.util.List;

@Repository
public interface AsignaturasRepository extends JpaRepository<Asignatura, Integer> {

    List<Asignatura> getAsignaturasByProfesor(Profesor profesor);
}
