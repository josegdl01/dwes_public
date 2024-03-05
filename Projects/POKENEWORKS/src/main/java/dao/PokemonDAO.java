package dao;

import dao.generic.GenericDAO;
import dao.generic.GenericDAOImpl;
import dao.generic.Identifiable;
import models.Pokemon;
import models.Tipo;

import java.util.List;

public interface PokemonDAO extends GenericDAO<Pokemon>{
    public List<Pokemon> getPokemonsByTipo(Tipo tipo);
    public List<Pokemon> getPokemonsByCategoria(String busqueda);

}
