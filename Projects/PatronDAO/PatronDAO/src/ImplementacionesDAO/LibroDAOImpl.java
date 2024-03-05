package ImplementacionesDAO;

import InterfacesDAO.LibroDAO;
import Modelos.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

  private List<Libro> Libros;

  /**
   * @param libros
   */
  public LibroDAOImpl(ArrayList<Libro> libros) {
    Libros = libros;
  }

  /** Constructor por defecto */
  public LibroDAOImpl() {
    Libros = new ArrayList<Libro>();
  }

  /**
   * @return
   */
  public List<Libro> obtenerTodos() {
    return Libros;
  }

  /**
   * @param libros
   */
  public void setLibros(List<Libro> libros) {
    Libros = libros;
  }

  /**
   * @return
   */
  @Override
  public Libro obtenerPorId(Integer id) {
    Libro libro = null;
    for (Libro l : this.Libros) {
      if (l.getId() == id) {
        libro = l;
      }
    }
    return libro;
  }

  /**
   * @param libro
   */
  @Override
  public void agregar(Libro libro) {
    this.Libros.add(libro);
  }

  /**
   * @param libro
   */
  @Override
  public void actualizar(Libro libro) {
    Libro libro_antiguo = obtenerPorId(libro.getId());

    if (libro_antiguo.getId() != -1) {
      this.Libros.remove(libro_antiguo);
      this.Libros.add(libro);
    }
  }

  /**
   * @param id
   */
  @Override
  public void eliminar(Integer id) {
    Libro libroAEliminar = obtenerPorId(id);
    Libros.remove(libroAEliminar);
  }
}
