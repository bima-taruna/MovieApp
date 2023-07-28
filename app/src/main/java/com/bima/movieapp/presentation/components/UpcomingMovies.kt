package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.UpcomingMovieViewModel

@Composable
fun UpcomingMovies(
    modifier: Modifier = Modifier,
    viewModel: UpcomingMovieViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    Column {
        SeeMore(
            title = "Upcoming",
            navController = navController,
            type = "upcoming"
        )
        Spacer(modifier = modifier.padding(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(state.movieList.subList(0, state.movieList.size / 2)) { movie->
              MoviesRow(movieList = movie, onClick = {
                  navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
              })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.CenterHorizontally))
        }
    }
}