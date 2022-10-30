package com.example.rickandmortycharacters.network

import com.example.rickandmortycharacters.model.CharactersModel
import com.example.rickandmortycharacters.model.ResultsEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersAPI {

    @GET("/api/character")
    fun getCharacters(@Query("page") page:Int, @Query("limit") limit:Int,  ): Call<ResultsEntity>

}

