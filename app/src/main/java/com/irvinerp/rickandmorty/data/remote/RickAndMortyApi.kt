package com.irvinerp.rickandmorty.data.remote

import com.irvinerp.rickandmorty.data.remote.dto.CharactersResponseDto
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {

  @GET("character")
  fun getCharacters(): Call<CharactersResponseDto>
}