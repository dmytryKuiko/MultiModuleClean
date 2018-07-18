package com.example.dimi.database.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.dimi.database.MovieDatabase
import io.reactivex.Flowable

@Dao
abstract class MovieDao: BaseDao<MovieDatabase> {

    @Query("SELECT * FROM ${TableNames.TABLE_MOVIE}")
    abstract fun getAllProducts(): Flowable<List<MovieDatabase>>
}