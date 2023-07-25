package com.bima.movieapp.viewmodel.state

import com.bima.movieapp.domain.model.Reviews

data class MovieReviewsState(
    val isLoading:Boolean = false,
    val Reviews:List<Reviews> = emptyList(),
    val error:String = ""
)
