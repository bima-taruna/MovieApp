
package com.bima.movieapp.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.presentation.components.DetailContent
import com.bima.movieapp.presentation.components.tabs.DetailTabs
import com.bima.movieapp.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailViewModel = hiltViewModel(),

    ) {
    val state = viewModel.state.value
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Column {
            DetailContent(state = state)
            Spacer(modifier = modifier.padding(16.dp))
            DetailTabs(content = state.movie?.overview.toString(), movieId = state.movie?.id.toString())
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }

    }
}