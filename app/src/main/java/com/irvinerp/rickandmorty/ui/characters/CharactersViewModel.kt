package com.irvinerp.rickandmorty.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irvinerp.rickandmorty.domain.LoadCharactersCallback
import com.irvinerp.rickandmorty.domain.RickAndMortyRepository
import com.irvinerp.rickandmorty.domain.model.Character

class CharactersViewModel constructor(
  private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

  private val _characters = MutableLiveData<List<Character>>()
  val characters: LiveData<List<Character>> = _characters

  private val _error = MutableLiveData<String>()
  val error: LiveData<String> = _error

  init {
    getCharacters()
  }

  private fun getCharacters() {
    rickAndMortyRepository.loadCharacters(object : LoadCharactersCallback {
      override fun onCharactersLoaded(characters: List<Character>) {
        _characters.postValue(characters)
      }

      override fun onDataNotAvailable() {
        _error.postValue("Error loading characters")
      }
    })
  }
}