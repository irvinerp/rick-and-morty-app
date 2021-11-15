package com.irvinerp.rickandmorty.data.remote.dto

import com.irvinerp.rickandmorty.domain.model.Character

data class CharactersResponseDto(
  val info: Info,
  val results: List<Result>
)

fun CharactersResponseDto.toCharacters(): List<Character> =
  results.map {
    Character(
      it.id,
      it.image
    )
  }