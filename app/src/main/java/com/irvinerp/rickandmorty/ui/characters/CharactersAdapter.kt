package com.irvinerp.rickandmorty.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irvinerp.rickandmorty.databinding.CharacterViewBinding
import com.irvinerp.rickandmorty.domain.model.Character
import com.irvinerp.rickandmorty.ui.characters.CharactersAdapter.ViewHolder
import com.irvinerp.rickandmorty.utils.loadImage

class CharactersAdapter : ListAdapter<Character, ViewHolder>(CharactersDiffCallback()) {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = CharacterViewBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }

  inner class ViewHolder(private val binding: CharacterViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
      binding.characterImage.loadImage(character.image)
    }
  }
}

private class CharactersDiffCallback : DiffUtil.ItemCallback<Character>() {
  override fun areItemsTheSame(
    oldItem: Character,
    newItem: Character
  ): Boolean = oldItem.id == newItem.id

  override fun areContentsTheSame(
    oldItem: Character,
    newItem: Character
  ): Boolean = oldItem.image == newItem.image
}