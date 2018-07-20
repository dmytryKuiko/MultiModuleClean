package com.example.dimi.di

import com.example.dimi.presentation.MainActivity
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.di.MainProvider
import com.example.dimi.common.di.PaginatorProvider
import com.example.dimi.paginator.di.PaginatorComponent
import dagger.Component

@MainScope
@Component(
    dependencies = [AppProvider::class, PaginatorProvider::class],
    modules = [MainScreenModule::class]
)
interface MainScreenComponent : MainProvider {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(appComponent: AppProvider): MainScreenComponent {
            return DaggerMainScreenComponent.builder()
                .appProvider(appComponent)
                .paginatorProvider(PaginatorComponent.init())
                .build()
        }
    }
}