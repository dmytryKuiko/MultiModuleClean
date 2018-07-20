package com.example.dimi.paginator.di

import com.example.dimi.common.network.PopularMovies
import com.example.dimi.common.paginator.Paginator
import com.example.dimi.paginator.PaginatorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PaginatorModule {

    @Binds
    internal abstract fun bindPaginator(paginatorImpl: PaginatorImpl<PopularMovies>): Paginator<PopularMovies>
}