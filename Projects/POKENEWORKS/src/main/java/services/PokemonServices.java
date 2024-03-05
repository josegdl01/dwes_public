package services;

import models.Pokemon;

import java.util.List;

public interface PokemonServices {
    public void insertPokemon(Pokemon poke);
    public void deletePokemon(Pokemon poke);
    public Pokemon updatePokemon(Pokemon poke);
    public Pokemon selectPokemon(Long id);
    public List<Pokemon> insertPokemon();
}
