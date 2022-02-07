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
//    private Abilities abilities;
//    private BaseStats baseStats;


}
