package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Categoria implements Serializable, Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private long id;

  @Column(name = "Nombre")
  private String nombre;
  @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Pokemon> pokemons = new HashSet<>();



    public Long getId() {
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

    //HELPERS
    public void addPokemon(Pokemon pokemon){
        if(pokemon != null){
            this.pokemons.add(pokemon);
            pokemon.setCategoria(this);
        }
    }

    public void removePokemon(Pokemon pokemon){
        if(pokemon != null){
            this.pokemons.remove(pokemon);
            pokemon.setCategoria(null);
        }
    }
}
