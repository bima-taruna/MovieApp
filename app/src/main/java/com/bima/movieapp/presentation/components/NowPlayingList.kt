package com.bima.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bima.movieapp.domain.model.MovieList

@Composable
fun NowPlayingList(
    movieList: MovieList,
    onItemClick: (MovieList) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movieList) }
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(movieList.title!!, style = MaterialTheme.typography.bodyMedium)
        Text(movieList.voteAverage.toString(), style = MaterialTheme.typography.bodyMedium)
    }
}