package Test;

import ImplementacionesDAO.LibroDAOImpl;
import InterfacesDAO.LibroDAO;
import Modelos.Libro;

public class Test {
  public static void main(String[] args) {
    LibroDAO test = new LibroDAOImpl();

    // Agregamos libros a la lista
    Libro l1 = new Libro(1, "Juego de Tronos", "George R.R. Martin", 1996);
    Libro l2 = new Libro(2, "Los Girasoles Ciegos", "Alberto Méndez", 2004);
    Libro l3 = new Libro(3, "El Árbol de la Ciencia", "Pío Baroja", 1911);
    Libro l4 = new Libro(4, "La Divina Comedia", "Dante Alighieri", 1472);
    test.agregar(l1);
    test.agregar(l2);
    test.agregar(l3);
    test.agregar(l4);

    System.out.println("IMPRIMIMOS EL PRIMER LIBRO");
    System.out.println(test.obtenerPorId(1).toString());

    System.out.println("Cambiamos el autor del primer libro".toUpperCase());
    Libro l1Nuevo =
        new Libro(
            1,
            "Juego de Tronos",
            "George R.R. Martin (Aunque el guión de la serie lo escribió otro)",
            1996);
    test.actualizar(l1Nuevo);
    System.out.println(test.obtenerPorId(1));

    System.out.println("TODOS LOS LIBROS TRAS ACTUALIZAR");
    for (Libro l : test.obtenerTodos()) {
      System.out.println(l.toString());
    }

    System.out.println("BORRAR LIBRO 3");
    test.eliminar(3);

    System.out.println("TODOS LOS LIBROS TRAS ELIMINAR");
    for (Libro l : test.obtenerTodos()) {
      System.out.println(l.toString());
    }
  }
}
