package com.example.dimi.common.di

import com.example.dimi.common.network.PopularMovies
import com.example.dimi.common.paginator.Paginator

interface PaginatorProvider {
    fun providePaginator(): Paginator<PopularMovies>
}