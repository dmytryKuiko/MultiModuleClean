package com.example.dimi.database

import android.arch.persistence.room.Room
import com.example.dimi.common.App
import com.example.dimi.common.database.DatabaseClient
import com.example.dimi.common.network.Movie
import com.example.dimi.common.network.MovieParsed
import com.example.dimi.database.room.AppDatabase
import com.example.dimi.database.room.DATABASE_NAME
import com.example.dimi.database.room.MovieDao
import io.reactivex.Flowable
import javax.inject.Inject

class DatabaseClientImpl
@Inject constructor(private val app: App) : DatabaseClient {

    private val dao: MovieDao by lazy {
        Room.databaseBuilder(
            app.getApplicationContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
            .movieDao()
    }

    override fun getData(): Flowable<out List<MovieParsed>> = dao.getAllProducts()

    override fun insertData(model: MovieParsed) {
        MovieDatabase(model.id, model.title)
            .also { dao.insert(it) }
    }
}