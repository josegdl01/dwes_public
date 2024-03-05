package velazquez.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Debilidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "DebilidadPokemon",
            joinColumns = {@JoinColumn(name = "IdDebilidad")},
            inverseJoinColumns = {@JoinColumn(name = "IdPokemon")}
    )
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

    //HELPERS
    public void addPokemon(Pokemon poke){
        if(poke != null){
            this.pokemons.add(poke);
            poke.addDebilidad(this);
        }
    }
    public void removePokemon(Pokemon poke){
        if(poke != null){
            this.pokemons.remove(poke);
            poke.removeDebilidad(this);
        }
    }

    @Override
    public String toString() {
        return "Debilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Pokemons=" + pokemons +
                '}';
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Debilidad)) return false;
    Debilidad debilidad = (Debilidad) o;
    return id == debilidad.id
        && Objects.equals(nombre, debilidad.nombre)
        && Objects.equals(pokemons, debilidad.pokemons);
  }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pokemons);
    }
}
