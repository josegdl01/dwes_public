package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="Categoria",schema="pokemon") ESTA ETIQUETA SOLO ES NECESARIA SI QUIERES QUE EN LA BBDD Y EN EL SERVIDOR TENGAN NOMBRES DIFERENTES
public class Categoria implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pokemon> pokemons = new HashSet<>();

    public Categoria(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria() {}

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void addPokemon(Pokemon pokemon){
        if(pokemon != null){
            pokemons.add(pokemon);
            pokemon.setCategoria(this);
        }
    }

    public void removePokemon(Pokemon pokemon){
        if(pokemon != null){
            this.pokemons.remove(pokemon);
            pokemon.setCategoria(null);
        }
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
