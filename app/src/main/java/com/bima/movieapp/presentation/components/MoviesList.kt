package com.bima.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.MovieList
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MoviesList(
    movieList: MovieList,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .clickable {
                    onClick()
                }
        ) {
            GlideImage(
                imageModel = { Constant.IMG_URL_POSTER + movieList.posterPath },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Fit
                )
            )
        }
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