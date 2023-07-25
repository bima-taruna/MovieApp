package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.data.remote.dto.movieCastDto.MovieCastDto
import com.bima.movieapp.data.remote.dto.movieDetailDto.MovieDetailDto
import com.bima.movieapp.data.remote.dto.movieReviewsDto.MovieReviewsDto
import com.bima.movieapp.data.remote.dto.nowPlayingDto.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/{type}")
    suspend fun getNowPlayingMovies(
        @Path("type") type:String
    ) : MovieListDto

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId:String
    ) : MovieDetailDto

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId:String
    ) : MovieReviewsDto

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") movieId: String
    ) : MovieCastDto
}