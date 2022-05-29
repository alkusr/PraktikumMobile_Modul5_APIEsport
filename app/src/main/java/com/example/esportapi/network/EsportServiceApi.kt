package com.example.esportapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://the-lazy-media-api.vercel.app/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GameServiceApi{

    @GET("api/games/e-sport/?page=1")
    suspend fun getGames() : MutableList<Esport>
}

object GameApi{
    val retrofitServiceApi : GameServiceApi by lazy {
        retrofit.create(GameServiceApi::class.java)
    }
}