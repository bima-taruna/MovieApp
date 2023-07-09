package com.bima.movieapp.viewmodel

import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying

data class MovieDetailState(
    val isLoading:Boolean = false,
    val movie:Movie ?= null,
    val error:String = ""
)
