package com.bima.movieapp.viewmodel.state

import com.bima.movieapp.domain.model.MovieList

data class MoviesState(
    val isLoading:Boolean = false,
    val movieList:List<MovieList> = emptyList(),
    val error:String = ""
)
