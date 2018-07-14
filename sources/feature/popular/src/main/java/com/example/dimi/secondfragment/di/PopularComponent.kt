package com.example.dimi.secondfragment.di

import android.app.Activity
import com.example.dimi.common.di.MainProvider
import com.example.dimi.secondfragment.PopularFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [MainProvider::class],
    modules = [PopularModule::class]
)
interface PopularComponent {

    fun inject(popularFragment: PopularFragment)

    companion object {
        fun init(mainProvider: MainProvider): PopularComponent =
            DaggerPopularComponent.builder()
                .mainProvider(mainProvider)
                .build()
    }
}