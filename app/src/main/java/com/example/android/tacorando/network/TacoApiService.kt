package com.example.android.tacorando.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://taco-randomizer.herokuapp.com/"

// Use the Moshi Builder to create a Moshi object with the KotlinJsonAdapterFactory
private val moshi= Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Use Retrofit Builder with ScalarsConverterFactory and BaseURL
var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement the TacoApiService interface with @GET getTaco returning a string
interface TacoApiService {
    @GET("random/?full-taco=true")
    fun getTaco():
            Call<List<TacoItem>>
}

// Create the TacoAPI object using Retrofit to implement the TacoApiService
object TacoApi {
    val retrofitService: TacoApiService by lazy {
        retrofit.create(TacoApiService::class.java)
    }
}