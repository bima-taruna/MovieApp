package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.MovieList
import com.bima.movieapp.presentation.components.SearchBar
import com.bima.movieapp.viewmodel.SearchedMovieViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchedMovieViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = modifier.padding(8.dp))
        MovieList(state = state, navController = navController, nextPage = {viewModel.nextPage()})
    }
}