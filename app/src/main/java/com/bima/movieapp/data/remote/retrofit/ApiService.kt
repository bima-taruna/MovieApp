package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.data.remote.dto.MovieResponse
import com.bima.movieapp.data.remote.dto.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : List<NowPlayingResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieById(
        @Path("movieId") movieId:Int
    ) : MovieResponse
}