package com.bima.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bima.movieapp.presentation.FavoriteScreen
import com.bima.movieapp.presentation.HomeScreen
import com.bima.movieapp.presentation.ListScreen
import com.bima.movieapp.presentation.MovieDetailScreen
import com.bima.movieapp.presentation.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NowPlayingScreen.route
    ) {
        composable(
            route = Screen.NowPlayingScreen.route
        ) {
           HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route + "/{movieId}"
        ) {
            MovieDetailScreen()
        }
        composable(
            route = Screen.MovieSearchScreen.route
        ) {
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.MovieFavoriteScreen.route
        ) {
            FavoriteScreen(navController = navController)
        }
        composable(
            route = Screen.MovieListScreen.route + "/{type}"
        ) {
            ListScreen(navController = navController)
        }
    }
}