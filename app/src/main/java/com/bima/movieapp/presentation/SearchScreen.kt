package com.bima.movieapp.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.MovieList
import com.bima.movieapp.presentation.components.MovieListItem
import com.bima.movieapp.presentation.components.SearchBar
import com.bima.movieapp.presentation.navigation.Screen
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