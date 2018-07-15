package com.example.dimi.secondfragment.presentation

import android.support.v7.util.DiffUtil
import com.example.dimi.secondfragment.model.MovieDisplayable

class DiffUtilCallbackMovie : DiffUtil.ItemCallback<MovieDisplayable>() {
    override fun areItemsTheSame(oldItem: MovieDisplayable?, newItem: MovieDisplayable?): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: MovieDisplayable?,
        newItem: MovieDisplayable?
    ): Boolean = if (oldItem is MovieDisplayable.Movie && newItem is MovieDisplayable.Movie) {
        oldItem == newItem
    } else {
        oldItem?.javaClass == newItem?.javaClass
    }
}

