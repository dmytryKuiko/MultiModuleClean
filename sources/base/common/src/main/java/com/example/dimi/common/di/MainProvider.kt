package com.example.dimi.common.di

import com.example.dimi.common.main.MainPresenter

interface MainProvider {
    fun provideMainPresenter(): MainPresenter
}