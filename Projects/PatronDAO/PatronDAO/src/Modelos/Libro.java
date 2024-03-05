package Modelos;

public class Libro {
  private Integer id;
  private String titulo;
  private String autor;
  private Integer anyoPublicacion;

  /**
   * @param id
   * @param titulo
   * @param autor
   * @param anyoPublicacion
   */
  public Libro(Integer id, String titulo, String autor, Integer anyoPublicacion) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.anyoPublicacion = anyoPublicacion;
  }

  /** Constructor por defecto */
  public Libro() {
    this.id = -1;
    this.titulo = "";
    this.autor = "";
    this.anyoPublicacion = -1;
  }

  /**
   * Constructor de copia
   *
   * @param libro
   */
  public Libro(Libro libro) {
    this.id = libro.id;
    this.titulo = libro.titulo;
    this.autor = libro.autor;
    this.anyoPublicacion = libro.anyoPublicacion;
  }

  /**
   * @return
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * @param titulo
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * @return
   */
  public String getAutor() {
    return autor;
  }

  /**
   * @param autor
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * @return
   */
  public Integer getAnyoPublicacion() {
    return anyoPublicacion;
  }

  /**
   * @param anyoPublicacion
   */
  public void setAnyoPublicacion(Integer anyoPublicacion) {
    this.anyoPublicacion = anyoPublicacion;
  }

  @Override
  public String toString() {
    String cadena =
        this.titulo + " de " + this.autor + ". Publicado en el año " + this.anyoPublicacion;
    return cadena;
  }
}
