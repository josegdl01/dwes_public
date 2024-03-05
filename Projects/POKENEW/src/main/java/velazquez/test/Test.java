package velazquez.test;

import velazquez.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.models.*;
import velazquez.services.CategoriaServices;
import velazquez.services.PokemonServices;
import velazquez.services.TipoServices;
import velazquez.services.impl.CategoriaServicesImpl;
import velazquez.services.impl.PokemonServicesImpl;
import velazquez.services.impl.TipoServicesImpl;
import velazquez.utils.HibernateUtils;

public class Test {
  public static void main(String[] args) {

    final Logger log = LoggerFactory.getLogger(Test.class);

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    Session session = sessionFactory.openSession();

    PokemonServices pokemonServices = new PokemonServicesImpl(session);
    CategoriaServices categoriaServices = new CategoriaServicesImpl(session);
    TipoServices tipoServices = new TipoServicesImpl(session);

    Pokemon pokemon1 = new Pokemon();
    pokemon1.setNombre("Pakisosio");
    pokemon1.setDescripcion("Un wen pokesosio");
    pokemon1.setImagen("1234.png");

    Pokemon pokemon2 = new Pokemon();
    pokemon2.setNombre("Pikachups");
    pokemon2.setDescripcion("Un pokesosio electrizante");
    pokemon2.setImagen("12345.png");

    Pokemon pokemon3 = new Pokemon();
    pokemon3.setNombre("Charizard");
    pokemon3.setDescripcion("Lagarto gigante con alas que escupe fuego");
    pokemon3.setImagen("123456.png");

    Habilidad hab1 = new Habilidad();
    hab1.setNombre("Fumar");
    Habilidad hab2 = new Habilidad();
    hab2.setNombre("Beber servesa");
    Habilidad hab3 = new Habilidad();
    hab3.setNombre("Ver el beti");
    Habilidad hab4 = new Habilidad();
    hab4.setNombre("Ser un cuñao");
    Habilidad hab5 = new Habilidad();
    hab5.setNombre("Programar en JAVA");
    Habilidad hab6 = new Habilidad();
    hab6.setNombre("Ir al baño");
    Habilidad hab7 = new Habilidad();
    hab7.setNombre("Dormir la siesta");

    Categoria cat1 = new Categoria();
    cat1.setNombre("Normal");
    Categoria cat2 = new Categoria();
    cat2.setNombre("Legendario");
    Categoria cat3 = new Categoria();
    cat3.setNombre("Inexistente");

    categoriaServices.insertCategoria(cat1);
    categoriaServices.insertCategoria(cat2);
    categoriaServices.insertCategoria(cat3);

    Tipo tipo = new Tipo();
    tipo.setNombre("Fuego");
    Tipo tipo2 = new Tipo();
    tipo2.setNombre("Hielo");
    Tipo tipo3 = new Tipo();
    tipo3.setNombre("Servesa");

    Estadistica estadistica1 = new Estadistica();
    estadistica1.setAltura(15);
    estadistica1.setPeso(10);
    estadistica1.setAtaque(50);
    estadistica1.setDefensa(60);
    estadistica1.setAtEspecial(25);
    estadistica1.setDefEspecial(25);
    estadistica1.setVelocidad(35);

    Estadistica estadistica2 = new Estadistica();

    estadistica2.setAltura(10);
    estadistica2.setPeso(15);
    estadistica2.setAtaque(90);
    estadistica2.setDefensa(65);
    estadistica2.setAtEspecial(45);
    estadistica2.setDefEspecial(23);
    estadistica2.setVelocidad(80);

    Estadistica estadistica3 = new Estadistica();
    estadistica3.setAltura(50);
    estadistica3.setPeso(20);
    estadistica3.setAtaque(59);
    estadistica3.setDefensa(45);
    estadistica3.setAtEspecial(20);
    estadistica3.setDefEspecial(65);
    estadistica3.setVelocidad(20);

    Debilidad debilidad1 = new Debilidad();
    debilidad1.setNombre("Pavías de bacalao");
    Debilidad debilidad2 = new Debilidad();
    debilidad2.setNombre("Salmorejo");
    Debilidad debilidad3 = new Debilidad();
    debilidad3.setNombre("Papas Bravas");
    Debilidad debilidad4 = new Debilidad();
    debilidad4.setNombre("Glock 9mm");

    pokemon1.setCategoria(cat2);
    //    pokemon1.setEstadistica(estadistica1);
    pokemon1.setTipos(tipo2);
    //    pokemon1.addHabilidad(hab1); pokemon1.addHabilidad(hab2); pokemon1.addHabilidad(hab3);
    // pokemon1.addHabilidad(hab7);
    //    pokemon1.addDebilidad(debilidad4); pokemon1.addDebilidad(debilidad3);
    //
//    pokemon2.setCategoria(cat3);
    //    pokemon2.setEstadistica(estadistica2);
//    pokemon2.setTipos(tipo3);
    //    pokemon2.addHabilidad(hab1); pokemon2.addHabilidad(hab4); pokemon2.addHabilidad(hab5);
    // pokemon2.addHabilidad(hab6);
    //    pokemon2.addDebilidad(debilidad1); pokemon2.addDebilidad(debilidad2);
    //
//    pokemon3.setCategoria(cat1);
    //    pokemon3.setEstadistica(estadistica3);
//    pokemon3.setTipos(tipo);
    //    pokemon3.addHabilidad(hab4); pokemon3.addHabilidad(hab7); pokemon3.addHabilidad(hab2);
    // pokemon3.addHabilidad(hab3);
    //    pokemon3.addDebilidad(debilidad3); pokemon3.addDebilidad(debilidad2);
    // pokemon3.addDebilidad(debilidad1);
    //
    log.info("INSERTAMOS POKEMONS");
    pokemonServices.insertPokemon(pokemon1);
//    pokemonServices.insertPokemon(pokemon2);
//    pokemonServices.insertPokemon(pokemon3);

    session.close();
  }
}
