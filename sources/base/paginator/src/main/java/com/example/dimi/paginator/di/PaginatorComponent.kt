package com.example.dimi.paginator.di

import com.example.dimi.common.di.PaginatorProvider
import dagger.Component

@Component(modules = [PaginatorModule::class])
interface PaginatorComponent : PaginatorProvider {

    companion object {
        fun init(): PaginatorComponent =
            DaggerPaginatorComponent.builder().build()
    }
}