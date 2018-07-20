package com.example.dimi.database.di

import com.example.dimi.common.database.DatabaseClient
import com.example.dimi.database.DatabaseClientImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DatabaseModule {

    @Singleton
    @Binds
    internal abstract fun bindDatabaseClient(databaseClientImpl: DatabaseClientImpl): DatabaseClient
}