package velazquez.entregablefinaljgd.models;

import java.io.Serializable;
import java.util.Objects;

public class AlumnoAsignaturaId implements Serializable {

  private Integer alumno;
  private Integer asignatura;

  public AlumnoAsignaturaId() {
  }

  public Integer getAlumno() {
    return alumno;
  }

  public void setAlumno(Integer alumno) {
    this.alumno = alumno;
  }

  public Integer getAsignatura() {
    return asignatura;
  }

  public void setAsignatura(Integer asignatura) {
    this.asignatura = asignatura;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alumno, asignatura);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    AlumnoAsignaturaId other = (AlumnoAsignaturaId) obj;
    return Objects.equals(alumno, other.alumno) && Objects.equals(asignatura, other.asignatura);
  }
}
