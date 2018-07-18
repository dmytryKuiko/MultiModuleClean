package com.example.dimi.data

import com.example.dimi.MovieParsedImpl
import com.example.dimi.common.network.Movie
import com.example.dimi.common.network.MovieParsed
import io.reactivex.functions.Function
import javax.inject.Inject

class MainDataMapper
@Inject constructor() : Function<Movie, MovieParsed> {
    override fun apply(movie: Movie): MovieParsedImpl {
        val id = movie.id ?: 1
        val title = movie.title ?: "Star wars"
        return MovieParsedImpl(id, title)
    }
}