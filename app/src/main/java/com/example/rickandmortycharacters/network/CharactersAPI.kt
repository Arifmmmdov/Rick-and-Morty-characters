package com.example.rickandmortycharacters.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersAPI {

    @GET("/api/character")
    fun getCharacters(@Query("page") page:Int, @Query("limit") limit:Int,  ): Call<List<CharactersEntity>>

}