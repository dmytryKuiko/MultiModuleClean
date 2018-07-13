package com.example.dimi.network

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.common.network.Movie
import com.example.dimi.network.di.HeaderInterceptor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class NetworkClientImpl
@Inject constructor() : NetworkClient {

    private val retrofitService: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(getOkHttp())
            .addConverterFactory(getConverterFactory())
            .addCallAdapterFactory(getCallAdapterFactory())
            .build().create(RetrofitService::class.java)
    }

    override fun getRetrofitModel(): Single<out Movie> = retrofitService.getData()

    private fun getOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()

    private fun getConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    private fun getCallAdapterFactory(): RxJava2CallAdapterFactory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    companion object {
        const val SERVER_URL = "https://api.themoviedb.org/"
    }
}