package com.bima.movieapp.domain.use_case.get_fav_note

data class FavMovieUseCases(
    val getFav : GetFavMovieUseCase,
    val deleteMovie: DeleteMovie,
    val addMovie: AddMovie,
    val getByTitle: GetByTitle
)
