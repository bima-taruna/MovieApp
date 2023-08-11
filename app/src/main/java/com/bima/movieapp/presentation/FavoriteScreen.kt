@file:OptIn(ExperimentalComposeUiApi::class)

package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.FavoriteMovieItem
import com.bima.movieapp.presentation.components.SearchField
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.FavoriteMovieViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteMovieViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    var text by remember { mutableStateOf("") }
    val localKeyboard = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.padding(16.dp)) {
        SearchField(
            text = text,
            onChange = {
                text = it
                if (text.isBlank()) {
                    viewModel.getFavorite()
                }
            },
            keyboard = localKeyboard
        ) {
            viewModel.searchFavorite(text)
        }
        LazyColumn(modifier = modifier.fillMaxSize().padding(top = 16.dp)) {
            items(state.movies.size) { i ->
                val movie = state.movies[i]
                FavoriteMovieItem(movieList = movie, onItemClick = {
                    navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                })
            }
        }
        if (state.movies.isEmpty()) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Favorite Movies is Empty", textAlign = TextAlign.Center)
            }
        }
    }

}
