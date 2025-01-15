package com.irvinerp.rickandmorty.data

import com.irvinerp.rickandmorty.data.remote.RickAndMortyApi
import com.irvinerp.rickandmorty.data.remote.dto.toCharacters
import com.irvinerp.rickandmorty.domain.repository.LoadCharactersCallback
import com.irvinerp.rickandmorty.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl constructor(
  private val api: RickAndMortyApi,
  private val appExecutors: AppExecutors
) : RickAndMortyRepository {

  override fun loadCharacters(loadCharactersCallback: LoadCharactersCallback) {
    appExecutors.networkIO.execute {
      val response = api.getCharacters().execute()
      appExecutors.mainThread.execute {
        if (response.isSuccessful) {
          loadCharactersCallback.onCharactersLoaded(response.body()?.toCharacters() ?: emptyList())
        } else {
          println(response.message())
          loadCharactersCallback.onDataNotAvailable()
        }
      }
    }
  }
}