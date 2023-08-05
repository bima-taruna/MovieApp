package com.bima.movieapp.common

import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.model.MovieList

sealed class FavEvent {
    data class AddMovie(val movie: MovieList) : FavEvent()
    data class DeleteMovie(val movie:Movies) : FavEvent()
}
