package com.example.dimi.presentation

import com.example.dimi.common.main.MainPresenter
import com.example.dimi.common.network.Movie
import com.example.dimi.domain.MainInteractor
import io.reactivex.Observable
import javax.inject.Inject

class MainPresenterImpl
@Inject constructor(private val mainInteractor: MainInteractor) : MainPresenter {
    override fun getPopularMovies(): Observable<Movie> {
        TODO()//return mainInteractor.getPopularMovies()
    }
}