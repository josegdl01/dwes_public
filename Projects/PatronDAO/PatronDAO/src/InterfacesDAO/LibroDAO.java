package InterfacesDAO;

import Modelos.Libro;

import java.util.List;

public interface LibroDAO {
  public List<Libro> obtenerTodos();

  public Libro obtenerPorId(Integer id);

  public void agregar(Libro libro);

  public void actualizar(Libro libro);

  public void eliminar(Integer id);
}
