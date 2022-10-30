package com.example.rickandmortycharacters.model

data class CharactersModel(
    val img: String,
    val name: String,
    val gender: String,
    val status: String,
    val species: String,
    val type: String,
    val origin: Origin,
)

data class Origin(
    val name: String,
    val url: String,
)
