package com.bima.movieapp.viewmodel.state

import com.bima.movieapp.data.local.entity.Movies

data class FavState(
    val movies:List<Movies> = emptyList()
)
