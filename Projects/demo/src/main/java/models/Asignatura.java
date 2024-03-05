package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Asignatura implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "creditos", nullable = false, precision = 0)
    private Object creditos;
    @Basic
    @Column(name = "tipo", nullable = false)
    private Object tipo;
    @Basic
    @Column(name = "curso", nullable = false)
    private byte curso;
    @Basic
    @Column(name = "cuatrimestre", nullable = false)
    private byte cuatrimestre;
    @Basic
    @Column(name = "id_profesor", nullable = true)
    private Integer idProfesor;
    @Basic
    @Column(name = "id_grado", nullable = true)
    private Integer idGrado;
    @OneToMany(mappedBy = "asignaturaByIdAsignatura")
    private Collection<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturasById;
    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id")
    private Profesor profesorByIdProfesor;
    @ManyToOne
    @JoinColumn(name = "id_grado", referencedColumnName = "id")
    private Grado gradoByIdGrado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getCreditos() {
        return creditos;
    }

    public void setCreditos(Object creditos) {
        this.creditos = creditos;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public byte getCurso() {
        return curso;
    }

    public void setCurso(byte curso) {
        this.curso = curso;
    }

    public byte getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(byte cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asignatura that = (Asignatura) o;

        if (id != that.id) return false;
        if (curso != that.curso) return false;
        if (cuatrimestre != that.cuatrimestre) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (creditos != null ? !creditos.equals(that.creditos) : that.creditos != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (idProfesor != null ? !idProfesor.equals(that.idProfesor) : that.idProfesor != null) return false;
        if (idGrado != null ? !idGrado.equals(that.idGrado) : that.idGrado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (creditos != null ? creditos.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (int) curso;
        result = 31 * result + (int) cuatrimestre;
        result = 31 * result + (idProfesor != null ? idProfesor.hashCode() : 0);
        result = 31 * result + (idGrado != null ? idGrado.hashCode() : 0);
        return result;
    }

    public Collection<AlumnoSeMatriculaAsignatura> getAlumnoSeMatriculaAsignaturasById() {
        return alumnoSeMatriculaAsignaturasById;
    }

    public void setAlumnoSeMatriculaAsignaturasById(Collection<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturasById) {
        this.alumnoSeMatriculaAsignaturasById = alumnoSeMatriculaAsignaturasById;
    }

    public Profesor getProfesorByIdProfesor() {
        return profesorByIdProfesor;
    }

    public void setProfesorByIdProfesor(Profesor profesorByIdProfesor) {
        this.profesorByIdProfesor = profesorByIdProfesor;
    }

    public Grado getGradoByIdGrado() {
        return gradoByIdGrado;
    }

    public void setGradoByIdGrado(Grado gradoByIdGrado) {
        this.gradoByIdGrado = gradoByIdGrado;
    }
}
