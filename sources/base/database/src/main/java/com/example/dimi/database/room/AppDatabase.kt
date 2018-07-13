package com.example.dimi.database.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.dimi.database.MovieDatabase

@Database(entities = [(MovieDatabase::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun retrofitModelDao(): RetrofitModelDao
}