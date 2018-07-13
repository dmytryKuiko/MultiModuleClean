package com.example.dimi.di

import com.example.dimi.common.network.NetworkClient
import dagger.Module
import dagger.Provides

@Module
class MainScreenModule {

    @Provides
    fun provideString(networkClient: NetworkClient): String = networkClient.toString()
}