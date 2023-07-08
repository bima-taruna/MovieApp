package com.bima.movieapp.data.repository

import com.bima.movieapp.data.remote.response.Popular
import com.bima.movieapp.data.remote.retrofit.ApiService

class MovieRepository(
    private val apiService: ApiService
) {
    suspend fun getPopularMovies():List<Popular> {
        return apiService.getPopularMovies()
    }
}