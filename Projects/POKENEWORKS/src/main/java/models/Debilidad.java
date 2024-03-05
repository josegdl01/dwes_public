package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
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
    private Set<Pokemon> Pokemons = new HashSet<>();

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
}
