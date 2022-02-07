package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "pokemon")
public class Pokemon {
    @Id
    private int id;
    private String name;
    private String type;
    private String weakness;
    private double height;
    private double weight;
    private String species;
    private Abilities abilities;
    private BaseStats baseStats;

    public Pokemon(String name, String type, String weakness, double height,
    double weight, String species, Abilities abilities, BaseStats baseStats){
        this.name = name;
        this.type = type;
        this.weakness = weakness;
        this.height = height;
        this.weight = weight;
        this.species = species;
        this.abilities = abilities;
        this.baseStats = baseStats;
    }

    // public Pokemon(String string, String string2, String string3, double d, double e, String string4) {
    // }

    public String getPokemonName(){
        return name;
    }
}
