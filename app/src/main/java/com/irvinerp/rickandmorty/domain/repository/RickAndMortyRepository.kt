package com.irvinerp.rickandmorty.domain.repository

import com.irvinerp.rickandmorty.domain.model.Character

interface RickAndMortyRepository {

  fun loadCharacters(loadCharactersCallback: LoadCharactersCallback)
}

interface LoadCharactersCallback {

  fun onCharactersLoaded(characters: List<Character>)

  fun onDataNotAvailable()
}