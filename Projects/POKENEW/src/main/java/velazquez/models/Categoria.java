package velazquez.models;

import velazquez.dao.generic.Identifiable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Categoria implements Serializable, Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
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

  @Override
  public String toString() {
    return "Categoria{"
        + "id="
        + id
        + ", nombre='"
        + nombre
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Categoria)) return false;
    Categoria categoria = (Categoria) o;
    return id == categoria.id
        && Objects.equals(nombre, categoria.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }
}
