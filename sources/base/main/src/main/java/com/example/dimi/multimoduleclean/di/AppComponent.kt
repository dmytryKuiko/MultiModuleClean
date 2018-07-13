package com.example.dimi.multimoduleclean.di

import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.DatabaseProvider
import com.example.dimi.common.di.NetworkProvider
import com.example.dimi.database.di.DaggerDatabaseComponent
import com.example.dimi.database.di.DatabaseComponent
import com.example.dimi.multimoduleclean.AppImpl
import com.example.dimi.network.di.DaggerNetworkComponent
import com.example.dimi.network.di.NetworkComponent
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [NetworkProvider::class, DatabaseProvider::class])
interface AppComponent : AppProvider {
    fun inject(app: AppImpl)

    companion object {
        fun init(app: AppImpl): AppComponent {
            return DaggerAppComponent.builder()
                .networkProvider(NetworkComponent.init())
                .databaseProvider(DatabaseComponent.init(app))
                .build()
        }
    }
}