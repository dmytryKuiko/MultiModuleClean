package com.example.dimi.di

import android.app.Activity
import com.example.dimi.MainActivity
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.MainProvider
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [MainScreenModule::class]
)
interface MainScreenComponent : MainProvider {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: Activity): Builder

        fun appProvider(appProvider: AppProvider): Builder

        fun build(): MainScreenComponent
    }

    companion object {
        fun init(appComponent: AppProvider, activity: MainActivity): MainScreenComponent {
            return DaggerMainScreenComponent.builder()
                .activity(activity)
                .appProvider(appComponent)
                .build()
        }
    }
}