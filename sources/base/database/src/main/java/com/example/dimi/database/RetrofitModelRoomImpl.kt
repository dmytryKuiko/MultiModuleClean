package com.example.dimi.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.dimi.common.network.RetrofitModel
import com.example.dimi.database.room.TableNames

@Entity(tableName = TableNames.TABLE_RETROFIT_MODEL)
class RetrofitModelRoomImpl(
    override val userId: Int,
    override val id: Int,
    override val title: String,
    override val body: String,

    @PrimaryKey(autoGenerate = true)
    val roomId: Int? = null
) : RetrofitModel