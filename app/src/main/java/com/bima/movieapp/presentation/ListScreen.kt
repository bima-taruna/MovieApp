@file:OptIn(ExperimentalMaterial3Api::class)

package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.MovieList
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
    val title = navController.currentBackStackEntry?.arguments?.getString("type")
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title.toString())
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        },
        content = {
            Box(modifier = modifier
                .fillMaxSize()
                .padding(it)) {
                MovieList(state = state, navController = navController, nextPage = {viewModel.nextPage()})
            }
        }
    )

}

