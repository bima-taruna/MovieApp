package com.bima.movieapp.common

import com.bima.movieapp.domain.model.MovieList

sealed class FavEvent {
    data class AddMovie<T>(val movie: T) : FavEvent()
    data class DeleteMovie<T>(val movie: T) : FavEvent()
}
