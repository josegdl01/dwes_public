package velazquez.pokespring.dataTransferObjects;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private Long id;
    private String nombre;
    private String imagen;
    private String categoria;
    private String descripcion;

    public Pokemon(Long id, String nombre, String imagen, String categoria, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Pokemon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
