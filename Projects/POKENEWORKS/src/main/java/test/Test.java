package test;

import dao.CategoriaDAO;
import dao.HabilidadDAO;
import dao.TipoDAO;
import dao.impl.CategoriaDAOImpl;
import dao.impl.HabilidadDAOImpl;
import dao.impl.TipoDAOImpl;
import models.Categoria;
import models.Habilidad;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import services.TipoServices;
import services.impl.PokemonServicesImpl;
import services.impl.TipoServicesImpl;
import utils.HibernateUtils;

public class Test {
  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    Session session = sessionFactory.openSession();

    PokemonServicesImpl pokemonServices = new PokemonServicesImpl(session);

    TipoServices tipoServices = new TipoServicesImpl(session);

    Categoria categoria = new Categoria();
    categoria.setNombre("Normal");

    Tipo tipo = new Tipo();
    tipo.setNombre("Humo");

    Habilidad habilidad = new Habilidad();
    habilidad.setNombre("Hab1");
    Habilidad habilidad2 = new Habilidad();
    habilidad2.setNombre("hab2");
    Habilidad habilidad3 = new Habilidad();
    habilidad3.setNombre("hab3");
    Habilidad habilidad4 = new Habilidad();
    habilidad4.setNombre("hab4");

    Pokemon pokemon = new Pokemon();
    pokemon.setNombre("pokepaki");
    pokemon.setDescripcion("Un wen pokesosio");
    pokemon.setImagen("IMAGEN");
    pokemon.setCategoria(categoria);
    pokemon.addTipo(tipo);
    pokemon.addHabilidad(habilidad);
    pokemon.addHabilidad(habilidad2);
    pokemon.addHabilidad(habilidad3);
    pokemon.addHabilidad(habilidad4);

    Pokemon pokemon2 = new Pokemon();
    pokemon2.setNombre("pokepiko");
    pokemon2.setDescripcion("Un wen pokesosio namber chu");
    pokemon2.setImagen("2365.png");
    pokemon2.setCategoria(categoria);
    pokemon2.addTipo(tipo);
    pokemon2.addHabilidad(habilidad4);
    pokemon2.addHabilidad(habilidad);
    pokemon2.addHabilidad(habilidad2);
    pokemon2.addHabilidad(habilidad3);

    pokemonServices.insertPokemon(pokemon2);
    pokemonServices.insertPokemon(pokemon);

    System.out.println(tipoServices.selectPokemonsByTipo(tipo));
    ;

    session.close();
  }
}
