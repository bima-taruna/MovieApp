package com.bima.movieapp.data.remote.dto.movieCastDto


import com.google.gson.annotations.SerializedName

data class MovieCastDto(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)