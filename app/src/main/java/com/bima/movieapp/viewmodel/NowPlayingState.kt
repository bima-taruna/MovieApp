package com.bima.movieapp.viewmodel

import com.bima.movieapp.domain.model.MovieList

data class NowPlayingState(
    val isLoading:Boolean = false,
    val movieList:List<MovieList> = emptyList(),
    val error:String = ""
)
