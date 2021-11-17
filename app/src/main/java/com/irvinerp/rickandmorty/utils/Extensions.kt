package com.irvinerp.rickandmorty.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
  Glide.with(context)
    .load(url)
    .thumbnail(0.1f)
    .into(this)
}