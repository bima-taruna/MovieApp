package com.bima.movieapp.domain.model

data class Movie(
    val id: Int?,
    val title: String?,
    val releaseDate: String?,
    val genres: List<String>?,
    val voteAverage: Any?,
    val overview: String?,
    val backdropPath: String?,
    val posterPath: String?,
)
