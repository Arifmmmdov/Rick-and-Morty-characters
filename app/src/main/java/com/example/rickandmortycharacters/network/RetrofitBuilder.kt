package com.example.rickandmortycharacters.network

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    fun getRetrofitInstance(): CharactersAPI {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/character/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CharactersAPI::class.java)
    }
}