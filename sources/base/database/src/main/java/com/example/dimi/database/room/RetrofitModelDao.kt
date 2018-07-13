package com.example.dimi.database.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.dimi.database.MovieDatabase
import io.reactivex.Flowable

@Dao
abstract class RetrofitModelDao: BaseDao<MovieDatabase> {

    @Query("SELECT * FROM ${TableNames.TABLE_RETROFIT_MODEL}")
    abstract fun getAllProducts(): Flowable<List<MovieDatabase>>
}