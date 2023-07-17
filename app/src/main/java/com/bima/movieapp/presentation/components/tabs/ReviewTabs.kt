package com.bima.movieapp.presentation.components.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.common.Constant
import com.bima.movieapp.presentation.Screen
import com.bima.movieapp.presentation.components.NowPlayingList
import com.bima.movieapp.presentation.components.ReviewCard
import com.bima.movieapp.viewmodel.MovieReviewsViewModel
import com.bima.movieapp.viewmodel.NowPlayingViewModel

@Composable
fun ReviewTabs(
    viewModel: MovieReviewsViewModel = hiltViewModel(),
    movieId:String
) {
    val state = viewModel.state.value
    viewModel.savedStateHandle[Constant.PARAM_MOVIE_ID] = movieId

    Box(modifier = Modifier.fillMaxHeight()) {
        if (state.Reviews.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No Reviews yet", Modifier.wrapContentSize())
            }
        } else {
            LazyColumn(modifier = Modifier) {
                items(state.Reviews) { review ->
                    ReviewCard(reviews = review)
                }
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