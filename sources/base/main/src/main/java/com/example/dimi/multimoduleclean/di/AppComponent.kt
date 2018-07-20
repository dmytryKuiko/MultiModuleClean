package com.example.dimi.multimoduleclean.di

import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.DatabaseProvider
import com.example.dimi.common.di.NetworkProvider
import com.example.dimi.common.di.SchedulersProvider
import com.example.dimi.database.di.DaggerDatabaseComponent
import com.example.dimi.database.di.DatabaseComponent
import com.example.dimi.multimoduleclean.AppImpl
import com.example.dimi.network.di.DaggerNetworkComponent
import com.example.dimi.network.di.NetworkComponent
import com.example.dimi.schedulers.di.SchedulersComponent
import dagger.Component

@Component(
    dependencies = [NetworkProvider::class, DatabaseProvider::class, SchedulersProvider::class],
    modules = [AppModule::class]
)
interface AppComponent : AppProvider {
    fun inject(app: AppImpl)

    companion object {
        fun init(app: AppImpl): AppComponent {
            return DaggerAppComponent.builder()
                .networkProvider(NetworkComponent.init())
                .databaseProvider(DatabaseComponent.init(app))
                .schedulersProvider(SchedulersComponent.init())
                .build()
        }
    }
}