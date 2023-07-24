package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.viewmodel.NowPlayingViewModel

@Composable
fun PopularMovie(
    modifier: Modifier = Modifier,
    viewModel: NowPlayingViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular",
                style = MaterialTheme.typography.titleLarge
            )
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "see more")
            }
        }
        Spacer(modifier = modifier.padding(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state.nowPlaying) { movie->
                PopularList(nowPlaying = movie)
            }
        }
    }
}