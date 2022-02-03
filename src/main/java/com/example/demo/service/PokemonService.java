package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll();
    }
}
