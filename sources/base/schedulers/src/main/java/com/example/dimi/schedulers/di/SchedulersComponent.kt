package com.example.dimi.schedulers.di

import com.example.dimi.common.di.SchedulersProvider
import dagger.Component

@Component(modules = [SchedulersModule::class])
interface SchedulersComponent : SchedulersProvider {

    companion object {
        fun init(): SchedulersProvider =
            DaggerSchedulersComponent.builder().build()
    }
}