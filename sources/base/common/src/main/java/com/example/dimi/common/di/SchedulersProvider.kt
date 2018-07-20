package com.example.dimi.common.di

import com.example.dimi.common.schedulers.SchedulersFactory

interface SchedulersProvider {

    fun provideAppSchedulers(): SchedulersFactory
}