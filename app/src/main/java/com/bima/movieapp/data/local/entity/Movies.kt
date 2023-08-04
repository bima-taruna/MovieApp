package com.bima.movieapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movies(
    @PrimaryKey val id: Int? = null,
    val title: String = "",
    val posterPath: String = "",
    val backdropPath: String = "",
    val voteAverage: Any = "",
    val releaseDate:String = ""
)
