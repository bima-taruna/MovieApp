package com.bima.movieapp.data.remote.dto.nowPlayingDto


import com.bima.movieapp.domain.model.MovieList
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun MovieListDto.toNowPlaying() : List<MovieList> {
    return results.map {
        MovieList(
            id = it.id,
            title = it.title,
            backdropPath = it.backdropPath,
            posterPath = it.posterPath,
            voteAverage = it.voteAverage
        )
    }

}