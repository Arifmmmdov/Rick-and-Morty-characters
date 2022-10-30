package com.example.rickandmortycharacters.model

import com.google.gson.annotations.SerializedName

data class CharactersModel(
    val image: String,
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

data class ResultsEntity(
    @SerializedName("results")
    val resultsEntity: List<CharactersModel>
)
