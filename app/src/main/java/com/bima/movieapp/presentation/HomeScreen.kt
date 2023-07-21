package com.bima.movieapp.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController, items = bottomNavigationItems)
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)){
                Navigation(navController = navController)
            }
        }
    )
}