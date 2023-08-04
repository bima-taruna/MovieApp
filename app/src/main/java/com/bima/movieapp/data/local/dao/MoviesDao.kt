package com.bima.movieapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bima.movieapp.data.local.entity.Movies
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getMovies() : Flow<List<Movies>>

//    @Query("SELECT * FROM movies WHERE title = :title")
//    fun getFavoriteUserByUsername(username: String): LiveData<GithubUserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(movies : Movies)

    @Delete
    suspend fun deleteMovies(movie:Movies)
}