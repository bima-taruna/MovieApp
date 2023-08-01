package com.bima.movieapp.domain.repository

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Cast
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.domain.model.Reviews
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getNowPlayingMovies() : Flow<Resource<List<MovieList>>>
    fun getPopularMovies() : Flow<Resource<List<MovieList>>>
    fun getTopRatedMovies() : Flow<Resource<List<MovieList>>>
    fun getUpcomingMovies() : Flow<Resource<List<MovieList>>>

    fun getMovieDetail(movieId: String): Flow<Resource<Movie>>

    fun getReview(movieId: String) : Flow<Resource<List<Reviews>?>>

    fun getMovieCast(movieId:String) : Flow<Resource<List<Cast>?>>

    fun  getMovieList(type:String, page:Int) :Flow<Resource<List<MovieList>>>
    fun  getSearchedMovie(query:String) :Flow<Resource<List<MovieList>>>
}