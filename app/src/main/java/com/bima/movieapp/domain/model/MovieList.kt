package com.bima.movieapp.domain.model

data class MovieList(
    val id: Int?,
    val title: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val voteAverage: Any?,
    val releaseDate:String? = "TBA"
)
