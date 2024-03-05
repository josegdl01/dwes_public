package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;

public interface AlumnoAsignaturaRepository extends JpaRepository<AlumnoAsignatura, Alumno> {

    AlumnoAsignatura getAlumnoAsignaturaByAlumno_IdAndAsignatura_Id(Integer id1, Integer id2);
}
