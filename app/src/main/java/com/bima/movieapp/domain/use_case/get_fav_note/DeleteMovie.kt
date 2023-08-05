package com.bima.movieapp.domain.use_case.get_fav_note

import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.repository.MovieRepository

class DeleteMovie(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movies) {
        repository.deleteMovies(movie)
    }
}