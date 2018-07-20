package com.example.dimi.network.di

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.network.HeaderInterceptor
import com.example.dimi.network.NetworkClientImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    internal abstract fun bindsNetworkClient(networkClientImpl: NetworkClientImpl): NetworkClient

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        @JvmStatic
        @Provides
        fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


        @JvmStatic
        @Provides
        fun provideCallAdapterFactory(): RxJava2CallAdapterFactory =
            RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }
}