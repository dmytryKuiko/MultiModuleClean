package com.example.dimi.database

import android.arch.persistence.room.Room
import com.example.dimi.common.App
import com.example.dimi.common.database.DatabaseClient
import com.example.dimi.common.di.AppProvider
import com.example.dimi.common.network.RetrofitModel
import com.example.dimi.database.room.AppDatabase
import com.example.dimi.database.room.DATABASE_NAME
import com.example.dimi.database.room.RetrofitModelDao
import io.reactivex.Flowable
import javax.inject.Inject

class DatabaseClientImpl
@Inject constructor(private val app: App) : DatabaseClient {

    private val dao: RetrofitModelDao by lazy {
        Room.databaseBuilder(
            app.getApplicationContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
            .retrofitModelDao()
    }

    override fun getData(): Flowable<out List<RetrofitModel>> = dao.getAllProducts()

    override fun insertData(model: RetrofitModel) {
        RetrofitModelRoomImpl(model.userId, model.id, model.title, model.body)
            .also { dao.insert(it) }
    }
}