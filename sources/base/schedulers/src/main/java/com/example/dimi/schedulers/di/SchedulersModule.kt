package com.example.dimi.schedulers.di

import com.example.dimi.common.schedulers.SchedulersFactory
import com.example.dimi.schedulers.AppSchedulers
import dagger.Binds
import dagger.Module

@Module
abstract class SchedulersModule {

    @Binds
    internal abstract fun bindAppSchedulers(appSchedulers: AppSchedulers): SchedulersFactory
}