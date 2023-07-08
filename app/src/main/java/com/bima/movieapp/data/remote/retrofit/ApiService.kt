package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : List<NowPlaying>

    @GET("movie/{movieId}")
    suspend fun getMovieById(
        @Path("movieId") movieId:String
    ) : Movie
}