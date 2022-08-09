package com.irvinerp.rickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irvinerp.rickandmorty.data.AppExecutors
import com.irvinerp.rickandmorty.data.RetrofitFactory
import com.irvinerp.rickandmorty.data.RickAndMortyRepositoryImpl

class CharactersViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            return CharactersViewModel(
                RickAndMortyRepositoryImpl(RetrofitFactory.getRickAndMortyApi(), AppExecutors())
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class $modelClass")
    }

    companion object {

        private var INSTANCE: CharactersViewModelFactory? = null

        @JvmStatic
        fun getInstance(): CharactersViewModelFactory {
            if (INSTANCE == null) {
                synchronized(CharactersViewModelFactory::javaClass) {
                    INSTANCE = CharactersViewModelFactory()
                }
            }
            return INSTANCE!!
        }
    }
}