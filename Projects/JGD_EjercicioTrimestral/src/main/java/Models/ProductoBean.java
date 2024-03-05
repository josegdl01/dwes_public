package Models;

import java.io.Serializable;

public class ProductoBean implements Serializable {
    private String codigo;
    private String nombre;
    private String categoria;
    private String stock;
    private String precio;

    public ProductoBean() {}

    public ProductoBean(String codigo,
                        String nombre,
                        String categoria,
                        String stock,
                        String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoBean{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", stock='" + stock + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
