package com.example.dimi.di

import com.example.dimi.NavigatorImpl
import com.example.dimi.common.Navigator
import dagger.Binds
import dagger.Module

@Module
abstract class MainScreenModule {

    @Binds
    internal abstract fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator
}