package services.impl;

import dao.PokemonDAO;
import models.Pokemon;
import services.PokemonService;

import java.util.List;

public class PokemonServiceImpl implements PokemonService {

    private PokemonDAO pokemonDAO;

    public PokemonServiceImpl() {

    }

    /**
*
*/
    @Override
    public void insertPokemon() {

    }

/**
*
*/
    @Override
    public void deletePokemon() {

    }

/**
*
 * @return
*/
    @Override
    public Pokemon updatePokemon() {
        return null;
    }

/**
*
 * @param id
 * @return
*/
    @Override
    public Pokemon selectPokemon(long id) {
        return null;
    }

/**
*
 * @param name
 * @return
*/
    @Override
    public Pokemon selectPokemonByName(String name) {
        return null;
    }

/**
*
 * @return
*/
    @Override
    public List<Pokemon> selectAllPokemon() {
        return null;
    }
}
