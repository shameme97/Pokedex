package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    public PokemonRepository pokemonRepository;

    @Override
    public String getAllPokemon(){
        List<Pokemon>pokemonList = new ArrayList<Pokemon>();
        pokemonList = pokemonRepository.findAll();
        return showAllPokemon(pokemonList);
    }

    @Override
    public String addPokemon(Pokemon pokemon){
        pokemonRepository.insert(pokemon);
        return pokemon.getName() + " added to Pokedex.";
    }

    @Override
    public String deletePokemon(Pokemon pokemon) {
        pokemonRepository.delete(pokemon);
        return pokemon.getName() + " removed from Pokedex.";
    }

    @Override
    public String updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return "Entry " + pokemon.getId() + " updated in Pokedex.\n" + showPokemon(pokemon);
    }

    @Override
    public String showPokemon(Pokemon pokemon) {
        return null;
    }

    public String info(Pokemon pokemon){
        return "===== Pokemon INFO =====\n Pokemon Name : " + pokemon.getName();
    }

    public String showAllPokemon(List<Pokemon> pokemonList){
        String pokedexEntries =  "=================POKEDEX=================\n";
        for (int i=0; i<pokemonList.size(); ++i){
            pokedexEntries += "Entry ID: " + pokemonList.get(i).getId() + "\n";
            pokedexEntries += "Name: " + pokemonList.get(i).getName() + "\n";
            pokedexEntries += "Type: " + pokemonList.get(i).getType() + "\n";
            pokedexEntries += "Weakness: " + pokemonList.get(i).getWeakness() + "\n";
            pokedexEntries += "Species: " + pokemonList.get(i).getSpecies() + "\n";
            pokedexEntries += "Height: " + pokemonList.get(i).getHeight() + " feet\n";
            pokedexEntries += "Weight: " + pokemonList.get(i).getWeight() + " kg\n";
            pokedexEntries += "-----------------------------------------\n";
        }
        return pokedexEntries;
    }

}
