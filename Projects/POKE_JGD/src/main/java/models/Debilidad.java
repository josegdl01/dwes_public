package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Debilidad implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "nombre")
  private String nombre;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "DebilidadPokemon",
      joinColumns = {@JoinColumn(name = "IdDebilidad")},
      inverseJoinColumns = {@JoinColumn(name = "IdPokemon")})
  private Set<Pokemon> pokemons = new HashSet<>();

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

  public Set<Pokemon> getPokemons() {
    return pokemons;
  }//GETTERS Y SETTERS

  public void addPokemon(Pokemon pokemon){
    if(pokemon != null){
      this.pokemons.add(pokemon);
    }
  }

  public void removePokemon(Pokemon pokemon){
    if(pokemon != null){
      this.pokemons.remove(pokemon);
//      pokemon.set
    }
  }

  @Override
  public String toString() {
    return "Debilidad{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
  }
}
