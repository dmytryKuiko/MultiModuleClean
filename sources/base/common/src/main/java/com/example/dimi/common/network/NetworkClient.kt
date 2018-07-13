package com.example.dimi.common.network

import io.reactivex.Single

interface NetworkClient {
    fun getRetrofitModel(): Single<out RetrofitModel>
}