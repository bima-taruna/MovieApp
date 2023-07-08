package com.bima.movieapp.domain.repository

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getNowPlayingMovies() : Flow<Resource<List<NowPlaying>>>

    suspend fun getMovieDetail(movieId: String): Flow<Resource<Movie>>
}