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

}
