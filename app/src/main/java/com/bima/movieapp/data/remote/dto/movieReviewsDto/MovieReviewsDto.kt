package com.bima.movieapp.data.remote.dto.movieReviewsDto


import com.bima.movieapp.domain.model.Reviews
import com.google.gson.annotations.SerializedName

data class MovieReviewsDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)

fun MovieReviewsDto.toReviews() : List<Reviews>? {
    return results?.map {
        Reviews(
            author = it?.author,
            avatar_path = it?.authorDetails?.avatarPath,
            contents = it?.content
        )
    }
}

