package com.bima.movieapp.presentation

sealed class Screen(val route:String) {
    object NowPlayingScreen: Screen("now_playing_screen")
    object MovieDetailScreen: Screen("movie_detail_screen")
}
