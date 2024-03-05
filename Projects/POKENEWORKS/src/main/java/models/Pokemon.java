package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pokemon implements Serializable, Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Imagen")
    private String imagen;

    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @OneToOne(
            mappedBy = "pokemon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Estadistica estadistica;
    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "pokemons"
    )
    private Set<Tipo> tipos = new HashSet<>();

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "pokemons"
    )
    private Set<Habilidad> habilidades = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public Set<Habilidad> getHabilidades() {
        return habilidades;
    }

    //HELPERS
    public void addTipo(Tipo tipo){
        if(tipo != null){
            this.tipos.add(tipo);
            tipo.getPokemons().add(this);
        }
    }

    public void removeTipo(Tipo tipo){
        if(tipo != null){
            this.tipos.remove(tipo);
            tipo.getPokemons().remove(this);
        }
    }

    public void addHabilidad(Habilidad habilidad){
        if(habilidad != null){
            this.habilidades.add(habilidad);
            habilidad.getPokemons().add(this);
        }
    }

    public void removeHabilidad(Habilidad habilidad){
        if(habilidad != null){
            this.habilidades.remove(habilidad);
            habilidad.getPokemons().remove(this);
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
                ", estadistica=" + estadistica +
                ", tipos=" + tipos +
                ", habilidades=" + habilidades +
                '}';
    }
}
