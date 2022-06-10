package com.example.mokel_on.RetAndApi

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

  //  private const val BASIC_URL = ""

    fun getInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("BASIC_URL")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}