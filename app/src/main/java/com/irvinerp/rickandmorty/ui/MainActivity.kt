package com.irvinerp.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.irvinerp.rickandmorty.R
import com.irvinerp.rickandmorty.R.layout
import com.irvinerp.rickandmorty.ui.characters.CharactersFragment
import com.irvinerp.rickandmorty.ui.characters.CharactersViewModel
import com.irvinerp.rickandmorty.ui.characters.CharactersViewModelFactory
import com.irvinerp.rickandmorty.utils.replaceFragmentInActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    replaceFragmentInActivity(CharactersFragment.newInstance(), R.id.contentFrame)
  }

  fun obtainViewModel(): CharactersViewModel =
    ViewModelProviders.of(this, CharactersViewModelFactory.getInstance())
      .get(CharactersViewModel::class.java)
}