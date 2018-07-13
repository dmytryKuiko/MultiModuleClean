package com.example.dimi.database.di

import com.example.dimi.common.di.DatabaseProvider
import com.example.dimi.common.App
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent : DatabaseProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(app: App): Builder

        fun build(): DatabaseComponent
    }

    companion object {
        fun init(app: App): DatabaseProvider =
                DaggerDatabaseComponent.builder()
                    .app(app)
                    .build()
    }
}