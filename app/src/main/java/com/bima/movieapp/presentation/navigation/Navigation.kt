package com.bima.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bima.movieapp.presentation.MovieDetailScreen
import com.bima.movieapp.presentation.NowPlayingScreen
import com.bima.movieapp.presentation.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.NowPlayingScreen.route
    ) {
        composable(
            route = Screen.NowPlayingScreen.route
        ) {
            NowPlayingScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route + "/{movieId}"
        ) {
            MovieDetailScreen()
        }
    }
}