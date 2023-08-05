package com.bima.movieapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movies(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val title: String? = "",
    val posterPath: String? = "",
    val backdropPath: String? = "",
    val voteAverage: Double? = 0.0,
    val releaseDate: String? = ""
)
