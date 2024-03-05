package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class AlumnoSeMatriculaAsignaturaPK implements Serializable {
    @Column(name = "id_alumno", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumno;
    @Column(name = "id_asignatura", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignatura;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlumnoSeMatriculaAsignaturaPK that = (AlumnoSeMatriculaAsignaturaPK) o;

        if (idAlumno != that.idAlumno) return false;
        if (idAsignatura != that.idAsignatura) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAlumno;
        result = 31 * result + idAsignatura;
        return result;
    }
}
