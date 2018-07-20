package com.example.dimi.common.main

import com.example.dimi.common.network.Movie
import io.reactivex.Observable

interface MainViewModel {
    fun getPopularMovies(): Observable<Movie>
}