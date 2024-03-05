package velazquez.models;

import velazquez.dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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
      cascade = {CascadeType.ALL},
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  private Estadistica estadistica;

  @ManyToMany(
      cascade = {CascadeType.ALL},
      mappedBy = "pokemons")
  private Set<Tipo> tipos = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "pokemons")
  private Set<Habilidad> habilidades = new HashSet<>();

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pokemons")
  private Set<Debilidad> debilidades = new HashSet<>();

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
    if (estadistica != null) {
      estadistica.setPokemon(this);
      this.estadistica = estadistica;
    }
  }

  public void removeEstadistica() {
    if (this.estadistica != null) {
      this.estadistica.setPokemon(null);
      this.estadistica = null;
    }
  }

  public Set<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(Tipo tipo) {
    if(tipo != null){
      this.tipos.add(tipo);
      tipo.getPokemons().add(this);
    }
  }

  public Set<Habilidad> getHabilidades() {
    return habilidades;
  }

  // HELPERS
  public void addHabilidad(Habilidad habilidad) {
    if (habilidad != null) {
      this.habilidades.add(habilidad);
      habilidad.getPokemons().add(this);
    }
  }

  public void removeHabilidad(Habilidad habilidad) {
    if (habilidad != null) {
      this.habilidades.remove(habilidad);
      habilidad.getPokemons().remove(this);
    }
  }

  public void addDebilidad(Debilidad debilidad) {
    if (debilidad != null) {
      this.debilidades.add(debilidad);
      debilidad.getPokemons().add(this);
    }
  }

  public void removeDebilidad(Debilidad debilidad) {
    if (debilidad != null) {
      this.debilidades.remove(debilidad);
      debilidad.getPokemons().remove(this);
    }
  }

  @Override
  public String toString() {
    return "Pokemon{"
        + "id="
        + id
        + ", nombre='"
        + nombre
        + '\''
        + ", descripcion='"
        + descripcion
        + '\''
        + ", imagen='"
        + imagen
        + '\''
        + ", categoria="
        + categoria
        + ", estadistica="
        + estadistica
        + ", tipos="
        + tipos
        + ", habilidades="
        + habilidades
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pokemon)) return false;
    Pokemon pokemon = (Pokemon) o;
    return Objects.equals(id, pokemon.id)
        && Objects.equals(nombre, pokemon.nombre)
        && Objects.equals(descripcion, pokemon.descripcion)
        && Objects.equals(imagen, pokemon.imagen)
        && Objects.equals(categoria, pokemon.categoria)
        && Objects.equals(estadistica, pokemon.estadistica)
        && Objects.equals(tipos, pokemon.tipos)
        && Objects.equals(habilidades, pokemon.habilidades)
        && Objects.equals(debilidades, pokemon.debilidades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, nombre, descripcion, imagen, categoria, estadistica, tipos, habilidades, debilidades);
  }
}
