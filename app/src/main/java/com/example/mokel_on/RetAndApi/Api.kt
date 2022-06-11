package com.example.mokel_on.RetAndApi

import com.example.mokel_on.Data.Data2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
  @GET("nama")
    @Headers("Authorization: token ZtG5qyPoCSrT9KVmw7cML6ndgKEz421M934FQ3K1")
  fun getData(
    @Query("nama") query: String
  ): Call<Data2>


}