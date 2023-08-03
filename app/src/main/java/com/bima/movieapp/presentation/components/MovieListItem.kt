package com.bima.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.MovieList
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieListItem(
    movieList: MovieList,
    onItemClick: (MovieList) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

            .clickable {
                onItemClick(movieList)
            }
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
       Row(
           modifier = modifier,

       ) {
           Card {
               GlideImage(
                   imageModel = {
                       Constant.IMG_URL_POSTER + movieList.posterPath
                   },
                   imageOptions = ImageOptions(
                       contentScale = ContentScale.Fit
                   ),
                   modifier = modifier.width(100.dp)
               )
           }
           Column(modifier = modifier.weight(1f).padding(horizontal = 16.dp, vertical = 16.dp)) {
               Text(movieList.title.toString(), style = MaterialTheme.typography.titleMedium, modifier = modifier.padding(bottom = 16.dp))
               Text(movieList.voteAverage.toString(), style = MaterialTheme.typography.labelMedium)
               Text(movieList.releaseDate.toString(), style = MaterialTheme.typography.labelMedium)
           }
       }
    }
}