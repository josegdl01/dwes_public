package models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String imagen;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @OneToOne(
            mappedBy = "pokemon",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Estadistica estadistica;

    //GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull Categoria categoria) {
        this.categoria = categoria;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }//GETTERS Y SETTERS


    //HELPERS
    public void removeEstadistica(){
        if(this.estadistica != null){
            this.estadistica.setPokemon(null);
            this.estadistica = null;
        }
    }

    public void setEstadistica(Estadistica estadistica) {
        if(estadistica != null){
            this.estadistica = estadistica;
            this.estadistica.setPokemon(this);
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
