package com.bima.movieapp.data.remote.dto.movieReviewsDto


import com.bima.movieapp.domain.model.Reviews
import com.google.gson.annotations.SerializedName

data class MovieReviewsDto(
    @SerializedName("author")
    val author: String,
    @SerializedName("author_details")
    val authorDetails: AuthorDetails,
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)

fun MovieReviewsDto.toReviews() : Reviews {
    return Reviews(
        author = author,
        avatar_path = authorDetails.avatarPath,
        contents = content
    )
}