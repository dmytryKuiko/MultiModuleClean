package com.example.dimi.common.database

import com.example.dimi.common.network.RetrofitModel
import io.reactivex.Flowable

interface DatabaseClient {
    fun getData(): Flowable<out List<RetrofitModel>>

    fun insertData(model: RetrofitModel)
}