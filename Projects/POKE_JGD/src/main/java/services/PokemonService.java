package services;

import models.Pokemon;

import java.util.List;

public interface PokemonService {
    public void insertPokemon();
    public void deletePokemon();
    public Pokemon updatePokemon();
    public Pokemon selectPokemon(long id);
    public Pokemon selectPokemonByName(String name);
    public List<Pokemon> selectAllPokemon();
}
