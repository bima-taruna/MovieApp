
package com.bima.movieapp.presentation
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.common.FavEvent
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.presentation.components.DetailContent
import com.bima.movieapp.presentation.components.tabs.DetailTabs
import com.bima.movieapp.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailViewModel = hiltViewModel(),

    ) {
    val state = viewModel.state.value
    val movieTitle = state.movie?.title
    var check by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val isMovieInDatabase by viewModel.getByTitle(movieTitle.toString())
        .collectAsState(initial = null)

    check = isMovieInDatabase == null
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Column {
            DetailContent(state = state, check = check, onClick = {
                if (isMovieInDatabase != null) {
                    viewModel.onEvent(FavEvent.DeleteMovie(state.movie))
                    Toast.makeText(context, "Delete ${state.movie?.title} from Favorite", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.onEvent(FavEvent.AddMovie(state.movie))
                    Toast.makeText(context, "Added ${state.movie?.title} to Favorite", Toast.LENGTH_SHORT).show()
                }
            })
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