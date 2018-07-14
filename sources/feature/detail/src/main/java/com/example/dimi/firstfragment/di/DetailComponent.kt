package com.example.dimi.firstfragment.di

import com.example.dimi.common.di.MainProvider
import com.example.dimi.firstfragment.DetailFragment
import dagger.Component

@Component(
    dependencies = [MainProvider::class],
    modules = [DetailModule::class]
)
interface DetailComponent {

    fun inject(fragment: DetailFragment)

    companion object {
        fun init(mainProvider: MainProvider): DetailComponent =
            DaggerDetailComponent.builder()
                .mainProvider(mainProvider)
                .build()
    }
}