package com.example.dimi.network.di

import com.example.dimi.common.di.NetworkProvider
import dagger.Component

@Component(modules = [(NetworkModule::class)])
interface NetworkComponent : NetworkProvider {
}