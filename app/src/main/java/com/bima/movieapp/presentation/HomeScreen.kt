package com.bima.movieapp.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bima.movieapp.presentation.navigation.BottomNavigation
import com.bima.movieapp.presentation.navigation.Navigation
import com.bima.movieapp.presentation.navigation.Screen


@Composable
fun HomeScreen(

) {
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
       Screen.NowPlayingScreen,
        Screen.MovieSearchScreen,
        Screen.MovieFavoriteScreen
    )
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("state", bottomBarState.toString())
    Log.d("route", navBackStackEntry?.destination?.route.toString())


    when (navBackStackEntry?.destination?.route) {
        "now_playing_screen" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "movie_search_screen" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "movie_favorite_screen" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "movie_detail_screen/{movieId}" -> {
            // Hide BottomBar
            bottomBarState.value = false
        }
    }
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarState.value,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                BottomNavigation(navController = navController, items = bottomNavigationItems)
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)){
                Navigation(navController = navController)
            }
        }
    )
}