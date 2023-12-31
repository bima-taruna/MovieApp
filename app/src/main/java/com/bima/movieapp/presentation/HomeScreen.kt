package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.ImageSwipe
import com.bima.movieapp.presentation.components.PopularMovie
import com.bima.movieapp.presentation.components.TopRatedMovie
import com.bima.movieapp.presentation.components.UpcomingMovies

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageSwipe(navController = navController)
        PopularMovie(navController = navController)
        TopRatedMovie(navController = navController)
        UpcomingMovies(navController = navController)
    }
}