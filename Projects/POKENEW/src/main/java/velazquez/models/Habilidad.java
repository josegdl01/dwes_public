package velazquez.models;

import velazquez.dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Habilidad implements Serializable, Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;
    @Column(name = "Nombre")
    private String nombre;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "HabilidadPokemon",
      joinColumns = {@JoinColumn(name = "IdHabilidad")},
      inverseJoinColumns = {@JoinColumn(name = "IdPokemon")})
  private Set<Pokemon> pokemons = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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
            poke.getHabilidades().add(this);
        }
    }

    public void removePokemon(Pokemon poke){
        if(poke != null){
            this.pokemons.remove(poke);
            poke.getHabilidades().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Habilidad)) return false;
    Habilidad habilidad = (Habilidad) o;
    return Id == habilidad.Id
        && Objects.equals(nombre, habilidad.nombre)
        && Objects.equals(pokemons, habilidad.pokemons);
  }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nombre, pokemons);
    }
}
