package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.state.MoviesState

@Composable
fun MovieList(
    state:MoviesState,
    modifier: Modifier = Modifier,
    navController:NavController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(state.movieList) { movie ->
            MovieListItem(
                movieList = movie,
                onItemClick = {
                    navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                })
        }
    }
    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )
    }
    if (state.isLoading) {
        CircularProgressIndicator(modifier = modifier)
    }
}