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
import com.bima.movieapp.domain.model.NowPlaying

@Composable
fun NowPlayingList(
    nowPlaying: NowPlaying,
    onItemClick: (NowPlaying) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(nowPlaying) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(nowPlaying.title!!, style = MaterialTheme.typography.bodyMedium)
        Text(nowPlaying.voteAverage.toString(), style = MaterialTheme.typography.bodyMedium)
    }
}