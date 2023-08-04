package com.bima.movieapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bima.movieapp.data.local.dao.MoviesDao
import com.bima.movieapp.data.local.entity.Movies


@Database(
    entities = [Movies::class],
    version = 1
)

abstract class MoviesDatabase:RoomDatabase() {
    abstract val moviesDao : MoviesDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}