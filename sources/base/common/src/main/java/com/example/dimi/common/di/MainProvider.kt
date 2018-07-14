package com.example.dimi.common.di

import com.example.dimi.common.Navigator

interface MainProvider {
    fun provideNavigator(): Navigator
}