package com.example.dimi.common.network

import io.reactivex.Single

interface NetworkClient {
    fun getInt(): Int

    fun getNetworkService(): Single<RetrofitModel>
}