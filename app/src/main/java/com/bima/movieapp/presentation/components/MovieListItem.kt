package com.bima.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clickable {
                onItemClick(movieList)
            }
            .padding(20.dp),
    ) {
       Row(
           modifier = modifier,
           verticalAlignment = Alignment.CenterVertically
       ) {
           GlideImage(
               imageModel = {
                    Constant.IMG_URL_POSTER + movieList.posterPath
                },
               imageOptions = ImageOptions(
                   contentScale = ContentScale.Crop
               ),
               modifier = modifier.width(150.dp)
           )
           Column(modifier = modifier.weight(1f)) {
               Text(movieList.title.toString(), style = MaterialTheme.typography.bodyMedium)
               Text(movieList.voteAverage.toString(), style = MaterialTheme.typography.bodyMedium)
           }
       }
    }
}