package com.example.dimi.data

import com.example.dimi.common.main.MovieParsed
import com.example.dimi.common.network.Movie
import io.reactivex.functions.Function
import javax.inject.Inject

class MainDataMapper
@Inject constructor() : Function<Movie, MovieParsed> {
    override fun apply(movie: Movie): MovieParsed {
        val id = movie.id ?: 1
        val title = movie.title ?: "Star wars"
        return MovieParsed(id, title)
    }
}