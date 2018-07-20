package com.example.dimi.common.di

import com.example.dimi.common.main.MainViewModel

interface MainProvider {
    fun provideMainViewModel(): MainViewModel
}