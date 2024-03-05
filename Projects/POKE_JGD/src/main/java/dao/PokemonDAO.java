package dao;

import dao.generic.GenericDAO;
import models.Pokemon;
import models.Tipo;

import java.util.List;

public interface PokemonDAO extends GenericDAO<Pokemon> {
    public List<String> getPokemonsNamesFromTipo(final Tipo tipo);
    public List<Pokemon> getAllPokemonsFromNameOrDescription(final String busqueda);
}
