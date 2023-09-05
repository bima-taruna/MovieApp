package com.bima.movieapp.presentation.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bima.movieapp.domain.model.MovieList

@Composable
fun MoviesRow(
    movieList: MovieList,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MovieCardSmall(movieList = movieList, onClick = onClick)
        Spacer(modifier = modifier.padding(4.dp))
        Text(
            text = movieList.title.toString(),
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = modifier
                .width(120.dp)
        )
        Spacer(modifier = modifier.padding(8.dp))
    }
}