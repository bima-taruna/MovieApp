package com.bima.movieapp.domain.use_case.get_fav_note

import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavMovieUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke() : Flow<List<Movies>> {
        return repository.getFavoriteMovies()
    }
}