package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Pokemon> findPokemon = pokemonRepository.findById(pokemon.getId());
        Pokemon updatedPokemon = findPokemon.orElse(null);
        if (updatedPokemon == null){  return "Pokemon not found!";  }
        else{
            if (pokemon.getName() != null){  updatedPokemon.setName(pokemon.getName());  }
            if (pokemon.getType() != null){  updatedPokemon.setType(pokemon.getType());  }
            if (pokemon.getWeakness() != null){  updatedPokemon.setWeakness(pokemon.getWeakness());  }
            if (pokemon.getSpecies() != null){  updatedPokemon.setSpecies(pokemon.getSpecies());  }
            if (pokemon.getWeight() != 0.0){  updatedPokemon.setWeight(pokemon.getWeight());  }
            if (pokemon.getHeight() != 0.0){  updatedPokemon.setHeight(pokemon.getHeight());  }
            pokemonRepository.save(updatedPokemon);
            return "Entry " + updatedPokemon.getId() + " updated in Pokedex.\n\n" + showPokemon(updatedPokemon);
        }

    }

    @Override
    public String findPokemon(String pokemonName) {
        List<Pokemon>pokemonList = new ArrayList<Pokemon>();
        pokemonList = pokemonRepository.findAll();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equals(pokemonName)) {
                return showPokemon(pokemon);
            }
        }
        return "Pokemon not found!";
    }

    public String showPokemon(Pokemon pokemon){
        String pokemonInfo = "";
        pokemonInfo += "Entry ID: " + pokemon.getId() + "\n";
        pokemonInfo += "Name: " + pokemon.getName() + "\n";
        pokemonInfo += "Type: " + pokemon.getType() + "\n";
        pokemonInfo += "Weakness: " + pokemon.getWeakness() + "\n";
        pokemonInfo += "Species: " + pokemon.getSpecies() + "\n";
        pokemonInfo += "Height: " + pokemon.getHeight() + " feet\n";
        pokemonInfo += "Weight: " + pokemon.getWeight() + " kg\n";
        return pokemonInfo;
    }

    public String showAllPokemon(List<Pokemon> pokemonList){
        String pokedexEntries =  "=================POKEDEX=================\n";
        for (Pokemon pokemon : pokemonList) {
            pokedexEntries += "Entry ID: " + pokemon.getId() + "\n";
            pokedexEntries += "Name: " + pokemon.getName() + "\n";
            pokedexEntries += "Type: " + pokemon.getType() + "\n";
            pokedexEntries += "Weakness: " + pokemon.getWeakness() + "\n";
            pokedexEntries += "Species: " + pokemon.getSpecies() + "\n";
            pokedexEntries += "Height: " + pokemon.getHeight() + " feet\n";
            pokedexEntries += "Weight: " + pokemon.getWeight() + " kg\n";
            pokedexEntries += "-----------------------------------------\n";
        }
        return pokedexEntries;
    }

}
