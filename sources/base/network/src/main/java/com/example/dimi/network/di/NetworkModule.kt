package com.example.dimi.network.di

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.network.NetworkClientImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    internal abstract fun bindsNetworkClient(networkClientImpl: NetworkClientImpl): NetworkClient
}