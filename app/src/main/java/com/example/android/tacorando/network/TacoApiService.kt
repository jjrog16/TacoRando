package com.example.android.tacorando.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://taco-randomizer.herokuapp.com/"

// Use Retrofit Builder with ScalarsConverterFactory and BaseURL
var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement the TacoApiService interface with @GET getTaco returning a string
interface TacoApiService {
    @GET("random")
    fun getTaco():
            Call<String>
}

// Create the TacoAPI object using Retrofit to implement the TacoApiService
object TacoApi {
    val retrofitService: TacoApiService by lazy {
        retrofit.create(TacoApiService::class.java)
    }
}