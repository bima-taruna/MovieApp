package com.bima.movieapp.viewmodel.state

import com.bima.movieapp.domain.model.Cast


data class MovieCastState (
    val isLoading:Boolean = false,
    val cast: List<Cast>? = emptyList(),
    val error:String = ""
)