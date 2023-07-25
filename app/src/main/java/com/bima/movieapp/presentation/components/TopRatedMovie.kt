package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.NowPlayingViewModel
import com.bima.movieapp.viewmodel.TopRatedViewModel

@Composable
fun TopRatedMovie(
    modifier: Modifier = Modifier,
    viewModel: TopRatedViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    Column {
        SeeMore(title = "Top Rated")
        Spacer(modifier = modifier.padding(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(state.movieList.subList(0, state.movieList.size / 2)) { movie->
                MoviesList(
                    movieList = movie,
                    onClick = {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                    }
                )
            }
        }
    }
}