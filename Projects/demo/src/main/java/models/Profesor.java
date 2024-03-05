package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Profesor implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nif", nullable = false, length = 9)
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
    private Date fechaNacimiento;
    @Basic
    @Column(name = "sexo", nullable = false)
    private Object sexo;
    @Basic
    @Column(name = "id_departamento", nullable = true)
    private Integer idDepartamento;
    @OneToMany(mappedBy = "profesorByIdProfesor")
    private Collection<Asignatura> asignaturasById;
    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    private Departamento departamentoByIdDepartamento;

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

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor profesor = (Profesor) o;

        if (id != profesor.id) return false;
        if (nif != null ? !nif.equals(profesor.nif) : profesor.nif != null) return false;
        if (nombre != null ? !nombre.equals(profesor.nombre) : profesor.nombre != null) return false;
        if (apellido1 != null ? !apellido1.equals(profesor.apellido1) : profesor.apellido1 != null) return false;
        if (apellido2 != null ? !apellido2.equals(profesor.apellido2) : profesor.apellido2 != null) return false;
        if (ciudad != null ? !ciudad.equals(profesor.ciudad) : profesor.ciudad != null) return false;
        if (direccion != null ? !direccion.equals(profesor.direccion) : profesor.direccion != null) return false;
        if (telefono != null ? !telefono.equals(profesor.telefono) : profesor.telefono != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(profesor.fechaNacimiento) : profesor.fechaNacimiento != null)
            return false;
        if (sexo != null ? !sexo.equals(profesor.sexo) : profesor.sexo != null) return false;
        if (idDepartamento != null ? !idDepartamento.equals(profesor.idDepartamento) : profesor.idDepartamento != null)
            return false;

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
        result = 31 * result + (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return result;
    }

    public Collection<Asignatura> getAsignaturasById() {
        return asignaturasById;
    }

    public void setAsignaturasById(Collection<Asignatura> asignaturasById) {
        this.asignaturasById = asignaturasById;
    }

    public Departamento getDepartamentoByIdDepartamento() {
        return departamentoByIdDepartamento;
    }

    public void setDepartamentoByIdDepartamento(Departamento departamentoByIdDepartamento) {
        this.departamentoByIdDepartamento = departamentoByIdDepartamento;
    }
}
