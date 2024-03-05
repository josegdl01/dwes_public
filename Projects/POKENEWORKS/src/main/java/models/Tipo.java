package models;

import dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tipo implements Serializable, Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "TipoPokemon",
            joinColumns = {@JoinColumn(name = "IdTipo")},
            inverseJoinColumns = {@JoinColumn(name = "IdPokemon")}
    )
    private Set<Pokemon> pokemons = new HashSet<>();

    public Tipo() {}

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
    public void addPokemon(Pokemon poke){
        if(poke != null){
            this.pokemons.add(poke);
            poke.getTipos().add(this);
        }
    }

    public void removePokemon(Pokemon poke){
        if(poke != null){
            this.pokemons.remove(poke);
            poke.getTipos().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}