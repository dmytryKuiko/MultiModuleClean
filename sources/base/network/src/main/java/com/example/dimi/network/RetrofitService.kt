package com.example.dimi.network

import com.example.dimi.common.network.RetrofitModel
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/posts/1")
    fun getData(): Single<RetrofitModel>
}