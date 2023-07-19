package com.bima.movieapp.data.remote.dto.movieCastDto


import com.bima.movieapp.data.remote.dto.nowPlayingDto.NowPlayingDto
import com.bima.movieapp.domain.model.NowPlaying
import com.google.gson.annotations.SerializedName
import com.bima.movieapp.domain.model.Cast

data class MovieCastDto(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)

fun MovieCastDto.toCast() : List<Cast> {
    return cast.map {
        Cast(
            name = it.name,
            character = it.character,
            profilePath = it.profilePath
        )
    }
}