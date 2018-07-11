package com.example.dimi.multimoduleclean.di

import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.NetworkProvider
import com.example.dimi.multimoduleclean.AppImpl
import com.example.dimi.network.di.DaggerNetworkComponent
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [NetworkProvider::class])
interface AppComponent : AppProvider {
    fun inject(app: AppImpl)

    companion object {
        fun init(app: AppImpl): AppComponent {
            return DaggerAppComponent.builder()
                .networkProvider(DaggerNetworkComponent.builder().build())
                .build()
        }
    }

}