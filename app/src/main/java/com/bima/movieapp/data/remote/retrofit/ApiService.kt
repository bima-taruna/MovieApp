package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.data.remote.dto.movieCastDto.MovieCastDto
import com.bima.movieapp.data.remote.dto.movieDetailDto.MovieDetailDto
import com.bima.movieapp.data.remote.dto.movieReviewsDto.MovieReviewsDto
import com.bima.movieapp.data.remote.dto.movieListDto.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/{type}")
    suspend fun getMovies(
        @Path("type") type:String,
        @Query("page") page:Int
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

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query:String,
        @Query("page") page:Int
    ) : MovieListDto
}