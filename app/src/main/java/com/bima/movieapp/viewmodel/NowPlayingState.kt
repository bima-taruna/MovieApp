package com.bima.movieapp.viewmodel

import com.bima.movieapp.domain.model.NowPlaying

data class NowPlayingState(
    val isLoading:Boolean = false,
    val nowPlaying:List<NowPlaying> = emptyList(),
    val error:String = ""
)
