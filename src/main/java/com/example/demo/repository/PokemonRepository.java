package com.example.demo.repository;
import com.example.demo.model.Pokemon;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository<Pokemon, Integer>{

}