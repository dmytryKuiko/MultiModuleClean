package com.example.dimi.network

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.common.network.RetrofitModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class NetworkClientImpl
@Inject constructor() : NetworkClient {
    override fun getInt(): Int = 2

    override fun getNetworkService(): Single<RetrofitModel> {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(getOkHttp())
            .addConverterFactory(getConverterFactory())
            .addCallAdapterFactory(getCallAdapterFactory())
            .build().create(RetrofitService::class.java).getData()
    }

    private fun getOkHttp(): OkHttpClient = OkHttpClient.Builder().build()

    private fun getConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    private fun getCallAdapterFactory(): RxJava2CallAdapterFactory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
}