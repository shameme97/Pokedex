package com.example.demo.controller;
import java.util.List;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/pokemonapi")
@AllArgsConstructor
public class PokemonController {
    
    @Autowired
    public PokemonService pokemonService;

    @GetMapping(value="/all")
    public String getAllPokemon(){
        return pokemonService.getAllPokemon();
    }

    @PostMapping(value = "/add")
    public String addPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }

    @DeleteMapping(value = "/delete/{entryId}")
    public String deletePokemon(@PathVariable("entryId") Pokemon pokemon){
        return pokemonService.deletePokemon(pokemon);
    }

    @PutMapping(value = "/update")
    public String updatePokemon(@RequestBody Pokemon pokemon){
        return pokemonService.updatePokemon(pokemon);
    }

    @GetMapping(value = "/show/{pokemonName}")
    public String findPokemon(@PathVariable("pokemonName") String pokemonName){
        return pokemonService.findPokemon(pokemonName);
    }
}
