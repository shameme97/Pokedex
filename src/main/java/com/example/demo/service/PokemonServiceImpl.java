package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PokemonServiceImpl {

    @Autowired
    public PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll();
    }

    public String addPokemon(Pokemon pokemon){
        pokemonRepository.insert(pokemon);
        return "Pokemon added to Pokedex\n" + info(pokemon);
    }

    public String info(Pokemon pokemon){
        return "===== Pokemon INFO =====\n Pokemon Name : " + pokemon.getName();
    }
}
