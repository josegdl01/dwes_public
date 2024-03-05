package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Habilidad implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "nombre")
  private String nombre;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "HabilidadPokemon",
      joinColumns = {@JoinColumn(name = "IdHabilidad")},
      inverseJoinColumns = {@JoinColumn(name = "IdPokemon")})
  private Set<Pokemon> pokemons = new HashSet<>();

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

  public Set<Pokemon> getPokemons() {
    return pokemons;
  }

  public void setPokemons(Set<Pokemon> pokemons) {
    this.pokemons = pokemons;
  }

  @Override
  public String toString() {
    return "Habilidad{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
  }
}
