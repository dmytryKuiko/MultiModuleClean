package com.example.dimi.secondfragment.model

sealed class MovieDisplayable {
    data class Movie(
        val id: Int,
        val title: String
    ) : MovieDisplayable()

    object Last : MovieDisplayable()

    object Loading : MovieDisplayable()

    object Error : MovieDisplayable()
}