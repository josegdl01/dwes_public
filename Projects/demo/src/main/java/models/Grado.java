package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Grado implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "gradoByIdGrado")
    private Collection<Asignatura> asignaturasById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grado grado = (Grado) o;

        if (id != grado.id) return false;
        if (nombre != null ? !nombre.equals(grado.nombre) : grado.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<Asignatura> getAsignaturasById() {
        return asignaturasById;
    }

    public void setAsignaturasById(Collection<Asignatura> asignaturasById) {
        this.asignaturasById = asignaturasById;
    }
}
