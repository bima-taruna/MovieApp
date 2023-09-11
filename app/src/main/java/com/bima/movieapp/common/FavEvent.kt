package com.bima.movieapp.common

sealed class FavEvent {
    data class AddMovie<T>(val movie: T) : FavEvent()
    data class DeleteMovie<T>(val movie: T) : FavEvent()
}
