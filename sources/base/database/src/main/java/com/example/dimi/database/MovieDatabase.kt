package com.example.dimi.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.dimi.common.network.Movie
import com.example.dimi.common.network.MovieParsed
import com.example.dimi.database.room.TableNames

@Entity(tableName = TableNames.TABLE_MOVIE)
class MovieDatabase(
    override val id: Int,
    override val title: String,

    @PrimaryKey(autoGenerate = true)
    val roomId: Long? = null
) : MovieParsed