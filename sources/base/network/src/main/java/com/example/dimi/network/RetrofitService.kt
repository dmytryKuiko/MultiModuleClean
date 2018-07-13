package com.example.dimi.network

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("3/movie/11")
    fun getData(): Single<MovieNetwork>
}