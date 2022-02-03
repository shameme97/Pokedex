package com.example.demo.controller;
import java.util.List;

import com.example.demo.model.Pokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pokemonapi")
@AllArgsConstructor
public class PokemonController {
    
    private final PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> fetchAllPokemon(){
        return pokemonService.getAllPokemon();
    }

}
