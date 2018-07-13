package com.example.dimi.network

import com.example.dimi.common.network.GenreWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("3/genre/movie/list")
    fun getGenres(): Single<GenreWrapperNetwork>

    @GET("3/movie/{id}")
    fun getMovieById(@Path("id") id: Int): Single<MovieNetwork>
}