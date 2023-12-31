package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.state.MoviesState

@Composable
fun MovieList(
    state:MoviesState,
    modifier: Modifier = Modifier,
    navController:NavController,
    nextPage : () -> Unit,
) {
    val lazyColumnListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state=lazyColumnListState
    ) {
        items(state.movieList.size) { i ->
            val movie = state.movieList[i]
            LaunchedEffect(i >= state.movieList.size - 1 && !state.isLoading) {
                nextPage()
            }
            MovieListItem(
                movieList = movie,
                onItemClick = {
                    navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                })
        }
        item {
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }


}