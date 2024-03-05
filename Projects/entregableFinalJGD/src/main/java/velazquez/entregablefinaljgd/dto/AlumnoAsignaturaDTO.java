package velazquez.entregablefinaljgd.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import velazquez.entregablefinaljgd.models.Alumno;
import velazquez.entregablefinaljgd.models.AlumnoAsignatura;
import velazquez.entregablefinaljgd.models.Asignatura;

import java.util.Objects;

public class AlumnoAsignaturaDTO {

    private Alumno alumno;

    private Asignatura asignatura;

    private int nota;

    public AlumnoAsignaturaDTO() {}

    public AlumnoAsignaturaDTO(Alumno alumno, Asignatura asignatura, int nota) {
        super();
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public AlumnoAsignaturaDTO(Alumno alumno, Asignatura asignatura) {
        super();
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlumnoAsignaturaDTO that)) return false;

        if (nota != that.nota) return false;
        if (!Objects.equals(alumno, that.alumno)) return false;
        return Objects.equals(asignatura, that.asignatura);
    }

    @Override
    public int hashCode() {
        int result = alumno != null ? alumno.hashCode() : 0;
        result = 31 * result + (asignatura != null ? asignatura.hashCode() : 0);
        result = 31 * result + nota;
        return result;
    }

    @Override
    public String toString() {
        return "AlumnoAsignaturaDTO{" +
                "alumno=" + alumno +
                ", asignatura=" + asignatura +
                ", nota=" + nota +
                '}';
    }
}
