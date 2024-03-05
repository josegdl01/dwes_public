package velazquez.entregablefinaljgd.services;

import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;
import velazquez.entregablefinaljgd.models.Asignatura;

import java.util.List;

public interface AlumnoAsignaturaService {
    public List<AlumnoAsignatura> getAllAlumnoAsignatura();
    public AlumnoAsignatura getAlumnoAsignaturaByIds(Integer al, Integer as);
    public AlumnoAsignatura updateAlumnoAsigantura(AlumnoAsignatura als);
}
