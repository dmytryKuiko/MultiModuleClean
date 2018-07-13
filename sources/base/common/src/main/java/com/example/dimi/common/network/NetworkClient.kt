package com.example.dimi.common.network

import io.reactivex.Single

interface NetworkClient {
    fun getMovieById(id: Int): Single<out Movie>

    fun getGenres(): Single<out GenreWrapper>
}