package com.example.dimi.di

import com.example.dimi.common.main.MainPresenter
import com.example.dimi.data.MainRepository
import com.example.dimi.data.MainRepositoryImpl
import com.example.dimi.data.MainStore
import com.example.dimi.domain.MainInteractor
import com.example.dimi.data.MainStoreImpl
import com.example.dimi.domain.MainInteractorImpl
import com.example.dimi.presentation.MainPresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MainScreenModule {

    @MainScope
    @Binds
    internal abstract fun bindMainPresenter(mainPresenterImpl: MainPresenterImpl): MainPresenter

    @Binds
    internal abstract fun bindMainInteractor(mainInteractorImpl: MainInteractorImpl): MainInteractor

    @Binds
    internal abstract fun bindMainStore(mainStoreImpl: MainStoreImpl): MainStore

    @Binds
    internal abstract fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}