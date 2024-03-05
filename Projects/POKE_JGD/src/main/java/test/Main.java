package test;

import models.Categoria;
import models.Estadistica;
import models.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Main {
  static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

     //NO INICIALIZAMOS EL ID YA QUE SE AUTOINCREMENTARÁ SOLO
    Categoria categoria = new Categoria();
    categoria.setNombre("fantasma");

    Estadistica estadisticaPaki = new Estadistica();

    estadisticaPaki.setPeso(15.50);
    estadisticaPaki.setAltura(25.50);
    estadisticaPaki.setPs(350);
    estadisticaPaki.setAtaque(50);
    estadisticaPaki.setDefensa(50);
    estadisticaPaki.setAtEspecial(60);
    estadisticaPaki.setDfEspecial(60);
    estadisticaPaki.setVelocidad(75);

    Pokemon pokemon = new Pokemon();
    pokemon.setNombre("pakidermo");
    pokemon.setImagen("imagen");
    pokemon.setCategoria(categoria);
    pokemon.setDescripcion("Un wen pokesosio");
    pokemon.setEstadistica(estadisticaPaki);

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.persist(pokemon);

    session.getTransaction().commit();

    sessionFactory.close();
  }
}
