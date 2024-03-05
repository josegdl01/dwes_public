package velazquez.services.impl;

import velazquez.dao.PokemonDAO;
import velazquez.dao.impl.PokemonDAOImpl;
import velazquez.models.Pokemon;
import org.hibernate.Session;
import velazquez.services.PokemonServices;

import java.util.List;

public class PokemonServicesImpl implements PokemonServices {

    PokemonDAO pokeDAO;

    public PokemonServicesImpl(Session session){
        pokeDAO = new PokemonDAOImpl(session);
    }

    @Override
    public void insertPokemon(Pokemon poke) {
    System.out.println(poke);
        if(poke != null && poke.getId() == null){
            pokeDAO.insertItem(poke);
        }
    }

    @Override
    public void deletePokemon(Pokemon poke) {
        if(poke != null && poke.getId() != null){
            pokeDAO.deleteItem(poke);
        }
    }

    @Override
    public Pokemon updatePokemon(Pokemon poke) {
        if(poke != null && poke.getId() != null){
            pokeDAO.updateItem(poke);
        }
        return poke;
    }

    @Override
    public Pokemon selectPokemon(Long id) {
        Pokemon poke = null;
        if(id != null){
            return pokeDAO.selectItem(id);
        }
        return poke;
    }

    @Override
    public List<Pokemon> insertPokemon() {
        return pokeDAO.selectAllItems();
    }


    public List<Pokemon> selectPokesByNameOrDesc(String busqueda){
        return pokeDAO.getPokemonsByNameOrDescription(busqueda);
    }
}
