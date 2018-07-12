package com.example.dimi.di

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.common.network.RetrofitModel
import dagger.Module
import dagger.Provides
import io.reactivex.Single

@Module
class MainScreenModule {

    @Provides
    fun provideInt(networkClient: NetworkClient): Int = networkClient.getInt()

    @Provides
    fun provideString(networkClient: NetworkClient): String = networkClient.toString()

    @Provides
    fun provideModel(networkClient: NetworkClient): Single<RetrofitModel> = networkClient.getNetworkService()
}