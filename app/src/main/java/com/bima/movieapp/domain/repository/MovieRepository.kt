package com.bima.movieapp.domain.repository

import com.bima.movieapp.common.Resource
import com.bima.movieapp.data.remote.dto.nowPlayingDto.NowPlayingDto
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying
import com.bima.movieapp.domain.model.Reviews
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getNowPlayingMovies() : Flow<Resource<List<NowPlaying>>>

    fun getMovieDetail(movieId: String): Flow<Resource<Movie>>

    fun getReview(movieId: String) : Flow<Resource<List<Reviews>?>>
}