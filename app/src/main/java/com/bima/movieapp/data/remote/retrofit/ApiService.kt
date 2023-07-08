package com.bima.movieapp.data.remote.retrofit

import com.bima.movieapp.data.dto.NowPlaying
import retrofit2.http.GET

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : List<NowPlaying>
}