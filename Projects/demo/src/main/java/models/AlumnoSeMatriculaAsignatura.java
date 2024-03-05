package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumno_se_matricula_asignatura", schema = "entregable", catalog = "")
@IdClass(AlumnoSeMatriculaAsignaturaPK.class)
public class AlumnoSeMatriculaAsignatura implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_asignatura", nullable = false)
    private int idAsignatura;
    @Basic
    @Column(name = "nota", nullable = false)
    private int nota;
    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id", nullable = false)
    private Alumno alumnoByIdAlumno;
    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false)
    private Asignatura asignaturaByIdAsignatura;

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
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
        if (o == null || getClass() != o.getClass()) return false;

        AlumnoSeMatriculaAsignatura that = (AlumnoSeMatriculaAsignatura) o;

        if (idAlumno != that.idAlumno) return false;
        if (idAsignatura != that.idAsignatura) return false;
        if (nota != that.nota) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAlumno;
        result = 31 * result + idAsignatura;
        result = 31 * result + nota;
        return result;
    }

    public Alumno getAlumnoByIdAlumno() {
        return alumnoByIdAlumno;
    }

    public void setAlumnoByIdAlumno(Alumno alumnoByIdAlumno) {
        this.alumnoByIdAlumno = alumnoByIdAlumno;
    }

    public Asignatura getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(Asignatura asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }
}
