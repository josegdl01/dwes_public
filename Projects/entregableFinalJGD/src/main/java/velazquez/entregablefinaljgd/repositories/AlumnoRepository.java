package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import velazquez.entregablefinaljgd.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
