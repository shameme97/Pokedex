package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Abilities;
import com.example.demo.model.BaseStats;
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
            if (pokemon.getName() != null){
                updatedPokemon.setName(pokemon.getName());
            }
            if (pokemon.getType() != null){
                updatedPokemon.setType(pokemon.getType());
            }
            if (pokemon.getWeakness() != null){
                updatedPokemon.setWeakness(pokemon.getWeakness());
            }
            if (pokemon.getSpecies() != null){
                updatedPokemon.setSpecies(pokemon.getSpecies());
            }
            if (pokemon.getWeight() != 0.0){
                updatedPokemon.setWeight(pokemon.getWeight());
            }
            if (pokemon.getHeight() != 0.0){
                updatedPokemon.setHeight(pokemon.getHeight());
            }
            if (pokemon.getAbilities() != null){
                Abilities ability = updatedPokemon.getAbilities();
                if (pokemon.getAbilities().getAbility() != null){
                    ability.setAbility(pokemon.getAbilities().getAbility());
                }
                if (pokemon.getAbilities().getHiddenAbility() != null){
                    ability.setAbility(pokemon.getAbilities().getHiddenAbility());
                }
                updatedPokemon.setAbilities(ability);
            }
            if (pokemon.getBaseStats() != null){
                BaseStats newBaseStat = pokemon.getBaseStats();
                BaseStats updatedBaseStat = updatedPokemon.getBaseStats();
                if (newBaseStat.getHp() != 0){
                    updatedBaseStat.setHp(newBaseStat.getHp());
                }
                if (newBaseStat.getAttack() != 0){
                    updatedBaseStat.setAttack(newBaseStat.getAttack());
                }
                if (newBaseStat.getDefense() != 0){
                    updatedBaseStat.setDefense(newBaseStat.getDefense());
                }
                if (newBaseStat.getSpAtk() != 0){
                    updatedBaseStat.setSpAtk(newBaseStat.getSpAtk());
                }
                if (newBaseStat.getSpDef() != 0){
                    updatedBaseStat.setSpDef(newBaseStat.getSpDef());
                }
                if (newBaseStat.getSpeed() != 0){
                    updatedBaseStat.setSpeed(newBaseStat.getSpeed());
                }
                updatedPokemon.setBaseStats(updatedBaseStat);
            }
            pokemonRepository.save(updatedPokemon);
            return "============UPDATED ENTRY============\n" + showPokemon(updatedPokemon);
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
        String ability = pokemon.getAbilities().getAbility();
        String hiddenAbility = pokemon.getAbilities().getHiddenAbility();
        String pokemonInfo = "";
        pokemonInfo += "Entry ID: " + pokemon.getId() + "\n";
        pokemonInfo += "Name: " + pokemon.getName() + "\n";
        pokemonInfo += "Type: " + pokemon.getType() + "\n";
        pokemonInfo += "Weakness: " + pokemon.getWeakness() + "\n";
        pokemonInfo += "Species: " + pokemon.getSpecies() + "\n";
        pokemonInfo += "Height: " + pokemon.getHeight() + " feet\n";
        pokemonInfo += "Weight: " + pokemon.getWeight() + " kg\n";
        pokemonInfo += "Ability: " + ability + "\n";
        pokemonInfo += "Hidden Ability: " + hiddenAbility + "\n";
        pokemonInfo += getStringBaseStats(pokemon.getBaseStats()) + "\n";
        return pokemonInfo;
    }

    public String getStringBaseStats(BaseStats baseStats){
        String showBaseStats = "----Base Stats:----";
        showBaseStats += "\nHP: " + baseStats.getHp();
        showBaseStats += "\nAttack: " + baseStats.getAttack();
        showBaseStats += "\nDefense: " + baseStats.getDefense();
        showBaseStats += "\nSpAtk: " + baseStats.getSpAtk();
        showBaseStats += "\nSpDef: " + baseStats.getSpDef();
        showBaseStats += "\nSpeed: " + baseStats.getSpeed();
        return showBaseStats;
    }

    public String showAllPokemon(List<Pokemon> pokemonList){
        String pokedexEntries =  "=================POKEDEX=================\n";
        for (Pokemon pokemon : pokemonList) {
            String ability = pokemon.getAbilities().getAbility();
            String hiddenAbility = pokemon.getAbilities().getHiddenAbility();
            pokedexEntries += "Entry ID: " + pokemon.getId() + "\n";
            pokedexEntries += "Name: " + pokemon.getName() + "\n";
            pokedexEntries += "Type: " + pokemon.getType() + "\n";
            pokedexEntries += "Weakness: " + pokemon.getWeakness() + "\n";
            pokedexEntries += "Species: " + pokemon.getSpecies() + "\n";
            pokedexEntries += "Height: " + pokemon.getHeight() + " feet\n";
            pokedexEntries += "Weight: " + pokemon.getWeight() + " kg\n";
            pokedexEntries += "Ability: " + ability + "\n";
            pokedexEntries += "Hidden Ability: " + hiddenAbility + "\n";
            pokedexEntries += getStringBaseStats(pokemon.getBaseStats());
            pokedexEntries += "\n-----------------------------------------\n";
        }
        return pokedexEntries;
    }

}
