package com.irvinerp.rickandmorty.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.irvinerp.rickandmorty.databinding.FragmentCharactersBinding
import com.irvinerp.rickandmorty.ui.MainActivity

class CharactersFragment : Fragment() {

  private lateinit var viewDataBinding: FragmentCharactersBinding

  private lateinit var viewModel: CharactersViewModel

  private val charactersAdapter: CharactersAdapter by lazy { CharactersAdapter() }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewDataBinding = FragmentCharactersBinding.inflate(inflater, container, false).apply {
      viewModel = (activity as MainActivity).obtainViewModel()
      charactersRecyclerView.adapter = this@CharactersFragment.charactersAdapter
    }
    return viewDataBinding.root
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.apply {
      characters.observe(viewLifecycleOwner) { characters ->
        charactersAdapter.submitList(characters)
      }
    }
  }

  companion object {
    fun newInstance() = CharactersFragment()
  }
}