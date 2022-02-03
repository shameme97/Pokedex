package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
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
    private LocalDateTime added;
}
