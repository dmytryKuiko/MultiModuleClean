package com.example.dimi.di

import com.example.dimi.common.NetworkClient
import dagger.Module
import dagger.Provides

@Module
class MainScreenModule {

    @Provides
    fun provideInt(networkClient: NetworkClient): Int = networkClient.getInt()

    @Provides
    fun provideString(networkClient: NetworkClient): String = networkClient.toString()
}