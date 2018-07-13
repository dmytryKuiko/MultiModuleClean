package com.example.dimi.database.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.dimi.database.RetrofitModelRoomImpl

@Database(entities = [(RetrofitModelRoomImpl::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun retrofitModelDao(): RetrofitModelDao
}