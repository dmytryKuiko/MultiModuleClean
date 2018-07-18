package com.example.dimi.common.database

import com.example.dimi.common.network.MovieParsed
import io.reactivex.Flowable

interface DatabaseClient {
    fun getData(): Flowable<out List<MovieParsed>>

    fun insertData(model: MovieParsed)
}