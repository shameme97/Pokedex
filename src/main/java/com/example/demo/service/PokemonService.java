package com.example.demo.service;

import com.example.demo.model.Pokemon;

import java.util.List;

public interface PokemonService {
    public List<Pokemon> getAllPokemon();
    public String addPokemon(Pokemon pokemon);
    public String deletePokemon(Pokemon pokemon);
    public Pokemon updatePokemon(Pokemon pokemon);
    public String showPokemon(Pokemon pokemon);
}
