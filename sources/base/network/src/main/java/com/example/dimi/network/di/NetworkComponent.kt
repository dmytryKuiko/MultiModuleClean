package com.example.dimi.network.di

import com.example.dimi.common.di.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface NetworkComponent : NetworkProvider {
    companion object {
        fun init(): NetworkProvider = DaggerNetworkComponent.builder().build()
    }
}