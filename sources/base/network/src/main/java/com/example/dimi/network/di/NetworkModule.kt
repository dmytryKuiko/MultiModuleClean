package com.example.dimi.network.di

import com.example.dimi.common.network.NetworkClient
import com.example.dimi.network.NetworkClientImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkModule {
    @Binds
    internal abstract fun bindsNetworkClient(networkClientImpl: NetworkClientImpl): NetworkClient
}