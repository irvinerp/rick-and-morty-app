package com.irvinerp.rickandmorty.domain.usecases

import com.irvinerp.rickandmorty.common.Result
import com.irvinerp.rickandmorty.domain.model.Character
import com.irvinerp.rickandmorty.domain.repository.LoadCharactersCallback
import com.irvinerp.rickandmorty.domain.repository.RickAndMortyRepository

class LoadCharactersUseCase constructor(
	private val repository: RickAndMortyRepository
) {

	operator fun invoke(refresh: Boolean = false): Result<List<Character>> {
		var result: Result<List<Character>> = Result.Success(emptyList())
		repository.loadCharacters(object : LoadCharactersCallback {
			override fun onCharactersLoaded(characters: List<Character>) {
				result = Result.Success(characters)
			}

			override fun onDataNotAvailable() {
				result = Result.Error("")
			}
		})
		return result
	}
}