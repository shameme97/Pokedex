package com.example.demo.service;

import com.example.demo.model.Pokemon;

import java.util.List;

public interface PokemonService {
    public String getAllPokemon();
    public String addPokemon(Pokemon pokemon);
    public String deletePokemon(Pokemon pokemon);
    public String updatePokemon(Pokemon pokemon);
    public String findPokemon(String pokemonName);
}
