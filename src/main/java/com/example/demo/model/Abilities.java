package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Abilities {
    private String ability;
    private String hiddenAbility;

    public Abilities(String ability, String hiddenAbility) {
        this.ability = ability;
        this.hiddenAbility = hiddenAbility;
    }
}
