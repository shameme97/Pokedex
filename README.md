# Pokedex

This is a pet project made with Spring Boot. The Pokedex is a REST API application made for storing data on Pokemon.
Information on Pokemon can be added, updated, or removed from the Pokedex through sending and receiving API. The database
used for this project is MongoDB NoSQL.

## Dependencies:
  - Spring Data MongoDB
  - Spring Web
  - Spring Boot DevTools
  
## Tech Stack:
  - Java
  - Spring Boot
  - mongoDB
  - Postman
  - Docker
  - IntelliJ (Editor)
  
## Functionalities

This projected was tested using Postman, with server port set to 4021. 
Server port can be changed at this directory - `src > main > resources > application.properties`
  - REST Service Endpoints:
    + **POST**: <http://localhost:4021/pokemonapi/add> : Add a new Pokemon to the Pokedex
      Sample JSON for this request:
      `{
       "id": 1,
       "name": "Bulbasaur",
       "type": "Grass",
       "weakness":"Fire, Ice, Psychic, Flying",
       "height": 2.04,
       "weight": 15.2,
       "species": "Seed",
       "abilities": {
         "ability": "Overgrow",
         "hiddenAbility": "Chlorophyll"
       },
       "baseStats": {
           "hp": 45,
           "attack": 49,
           "defense": 49,
           "spAtk": 65,
           "spDef": 65,
           "speed": 45
       }
      }`
      
    + **GET**: <http://localhost:4021/pokemonapi/all> : Get list of all Pokemon in Pokedex
    
    + **DELETE**: <http://localhost:4021/pokemonapi/delete/{entryId}> : Remove a Pokemon by its entry ID
    
    + **PUT**: <http://localhost:4021/pokemonapi/update> : Update features of an existing Pokemon in Pokedex by its ID
      Sample JSON for this request:
      `{
       "id": 1,
       "weakness":"Water, Ground, Rock",
       "height": 3.04,
       "baseStats": {
          "hp": 39,
          "speed": 43
        }
      }`
      
    + **GET**: <http://localhost:4021/pokemonapi/show/{pokemonName}> : Get Pokemon by its Name
      

