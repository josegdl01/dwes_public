package models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Alumno implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nif", nullable = true, length = 9)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Basic
    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;
    @Basic
    @Column(name = "apellido2", nullable = true, length = 50)
    private String apellido2;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 25)
    private String ciudad;
    @Basic
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Basic
    @Column(name = "telefono", nullable = true, length = 9)
    private String telefono;
    @Basic
    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat
    private Date fechaNacimiento;
    @Basic
    @Column(name = "sexo", nullable = false)
    private Object sexo;
    @OneToMany(mappedBy = "alumnoByIdAlumno")
    private Collection<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturasById;

    public Alumno() {
    }

    public Alumno(int id,
                  String nif,
                  String nombre,
                  String apellido1,
                  String apellido2,
                  String ciudad,
                  String direccion,
                  String telefono,
                  Date fechaNacimiento,
                  Object sexo) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Object getSexo() {
        return sexo;
    }

    public void setSexo(Object sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (id != alumno.id) return false;
        if (nif != null ? !nif.equals(alumno.nif) : alumno.nif != null) return false;
        if (nombre != null ? !nombre.equals(alumno.nombre) : alumno.nombre != null) return false;
        if (apellido1 != null ? !apellido1.equals(alumno.apellido1) : alumno.apellido1 != null) return false;
        if (apellido2 != null ? !apellido2.equals(alumno.apellido2) : alumno.apellido2 != null) return false;
        if (ciudad != null ? !ciudad.equals(alumno.ciudad) : alumno.ciudad != null) return false;
        if (direccion != null ? !direccion.equals(alumno.direccion) : alumno.direccion != null) return false;
        if (telefono != null ? !telefono.equals(alumno.telefono) : alumno.telefono != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(alumno.fechaNacimiento) : alumno.fechaNacimiento != null)
            return false;
        if (sexo != null ? !sexo.equals(alumno.sexo) : alumno.sexo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido1 != null ? apellido1.hashCode() : 0);
        result = 31 * result + (apellido2 != null ? apellido2.hashCode() : 0);
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        return result;
    }

    public Collection<AlumnoSeMatriculaAsignatura> getAlumnoSeMatriculaAsignaturasById() {
        return alumnoSeMatriculaAsignaturasById;
    }

    public void setAlumnoSeMatriculaAsignaturasById(Collection<AlumnoSeMatriculaAsignatura> alumnoSeMatriculaAsignaturasById) {
        this.alumnoSeMatriculaAsignaturasById = alumnoSeMatriculaAsignaturasById;
    }
}
