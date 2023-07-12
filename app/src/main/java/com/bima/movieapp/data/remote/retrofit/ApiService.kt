package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.data.remote.dto.movieDetailDto.MovieDetailDto
import com.bima.movieapp.data.remote.dto.nowPlayingDto.NowPlayingDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : NowPlayingDto

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId:String
    ) : MovieDetailDto
}