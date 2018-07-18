package com.example.dimi.database.room

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(array: Array<T>): List<Long>

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}