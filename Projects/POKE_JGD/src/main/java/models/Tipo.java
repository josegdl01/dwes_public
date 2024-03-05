package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "PokemonTipo",
      joinColumns = {@JoinColumn(name = "IdTipo")},
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

    public void setPokemons(HashSet<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
