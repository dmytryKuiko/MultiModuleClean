package com.example.dimi.common.database

import com.example.dimi.common.network.Movie
import io.reactivex.Flowable

interface DatabaseClient {
    fun getData(): Flowable<out List<Movie>>

    fun insertData(model: Movie)
}