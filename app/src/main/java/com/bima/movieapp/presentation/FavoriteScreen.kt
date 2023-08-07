package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.FavoriteMovieItem
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.FavoriteMovieViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteMovieViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(state.movies.size) { i ->
            val movie = state.movies[i]
           FavoriteMovieItem(movieList = movie, onItemClick = {
               navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
           })
        }
    }

}