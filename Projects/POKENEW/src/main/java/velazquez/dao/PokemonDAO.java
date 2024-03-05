package velazquez.dao;

import velazquez.dao.generic.GenericDAO;
import velazquez.models.Pokemon;

import java.util.List;

public interface PokemonDAO extends GenericDAO<Pokemon>{
    public List<Pokemon> getPokemonsByNameOrDescription(String busqueda);

    public List<Pokemon> getPokemonsByImagenOrCategoria(String busqueda);

}
