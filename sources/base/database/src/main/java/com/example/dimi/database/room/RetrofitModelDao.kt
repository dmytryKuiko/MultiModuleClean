package com.example.dimi.database.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.dimi.common.network.RetrofitModel
import com.example.dimi.database.RetrofitModelRoomImpl
import io.reactivex.Flowable

@Dao
abstract class RetrofitModelDao: BaseDao<RetrofitModelRoomImpl> {

    @Query("SELECT * FROM ${TableNames.TABLE_RETROFIT_MODEL}")
    abstract fun getAllProducts(): Flowable<List<RetrofitModelRoomImpl>>
}