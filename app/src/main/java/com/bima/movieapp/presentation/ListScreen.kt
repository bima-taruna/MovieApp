package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Box
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.MovieListItem
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.MovieListViewModel

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    Box(modifier = modifier.fillMaxSize()) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
//        Text(text = state.error)
    }
}