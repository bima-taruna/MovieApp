package com.bima.movieapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String,val name:String ,val icon: ImageVector) {
    object NowPlayingScreen: Screen("now_playing_screen","Home", Icons.Filled.Home)
    object MovieSearchScreen: Screen("movie_search_screen","Search", Icons.Filled.Search)
    object MovieFavoriteScreen: Screen("movie_favorite_screen","Favorite", Icons.Filled.Favorite)
    object MovieDetailScreen: Screen("movie_detail_screen","None", Icons.Filled.AccountCircle)
    object MovieListScreen: Screen("movie_list_screen","None", Icons.Filled.AccountCircle)
}
