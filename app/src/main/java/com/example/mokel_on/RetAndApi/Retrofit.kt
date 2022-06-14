package com.example.mokel_on.RetAndApi

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

   private val BASIC_URL = "https://mokel-on-default-rtdb.firebaseio.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASIC_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(Api::class.java)

}