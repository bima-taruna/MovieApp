package com.bima.movieapp.data.remote.dto.movieCastDto


import com.bima.movieapp.domain.model.Cast
import com.google.gson.annotations.SerializedName

data class MovieCastDto(
    @SerializedName("cast")
    val cast: List<CastDto?>?,
    @SerializedName("crew")
    val crew: List<Crew?>?,
    @SerializedName("id")
    val id: Int?
)

fun MovieCastDto.toCast() : List<com.bima.movieapp.domain.model.Cast>? {
    return cast?.map {
        Cast(
            name = it?.name,
            profilePath = it?.profilePath,
            character = it?.character,
        )
    }
}