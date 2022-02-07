package com.example.demo.controller;
import java.util.List;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/pokemonapi")
@AllArgsConstructor
public class PokemonController {
    
    @Autowired
    public PokemonService pokemonService;


    @GetMapping(value="/all")
    public List<Pokemon> fetchAllPokemon(){
        return pokemonService.getAllPokemon();
    }



    @PostMapping(value = "/add")
    public String addPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }
}
