package com.example.demo;

import javax.management.Query;

import com.example.demo.model.Abilities;
import com.example.demo.model.BaseStats;
import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PokemonRepository pokemonRepository){
		return (args) -> {
			Abilities abilities = new Abilities(
				"Overgrow",
				"Chlorophyll"
			);
			BaseStats baseStats = new BaseStats(
				45, 49, 49, 65, 65, 45
			);
			Pokemon pokemon = new Pokemon(
				"Bulbasaur",
				"Grass",
				"Fire, Ice, Psychic, Flying",
				2.04,
				15.2,
				"Seed",
				abilities,
				baseStats
			);
			pokemonRepository.insert(pokemon);
		};
	}

}
