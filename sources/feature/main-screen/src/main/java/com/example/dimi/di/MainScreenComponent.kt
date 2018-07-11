package com.example.dimi.di

import com.example.dimi.MainActivity
import com.example.dimi.common.di.AppProvider
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [MainScreenModule::class]
)
interface MainScreenComponent {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(appComponent: AppProvider): MainScreenComponent {
            return DaggerMainScreenComponent.builder()
                .appProvider(appComponent)
                .build()
        }
    }
}