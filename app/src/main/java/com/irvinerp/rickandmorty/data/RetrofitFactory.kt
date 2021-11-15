package com.irvinerp.rickandmorty.data

import com.irvinerp.rickandmorty.BuildConfig
import com.irvinerp.rickandmorty.data.remote.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

  fun getRickAndMortyApi(): RickAndMortyApi {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(RickAndMortyApi::class.java)
  }
}