package com.example.mokel_on.RetAndApi

import com.example.mokel_on.Data.Data2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
  @GET("/alamat")
    @Headers("Authorization: token ZtG5qyPoCSrT9KVmw7cML6ndgKEz421M934FQ3K1")
  fun getAlamat(
    @Query("q") query: String
  ): Call<Data2>

  @GET("/nama bengkel")
  @Headers("Authorization: token ZtG5qyPoCSrT9KVmw7cML6ndgKEz421M934FQ3K1")
  fun getNamaBengkel(
    @Query("q") query: String
  ): Call<Data2>

  @GET("/rating")
  @Headers("Authorization: token ZtG5qyPoCSrT9KVmw7cML6ndgKEz421M934FQ3K1")
  fun getRating(
    @Query("q") query: String
  ): Call<Data2>

}