package com.bima.movieapp.common

import com.bima.movieapp.domain.model.MovieList

sealed class FavEvent {
    data class AddMovie(val movie: MovieList) : FavEvent()
    data class DeleteMovie(val movie: MovieList) : FavEvent()
}
