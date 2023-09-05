package com.bima.movieapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.MovieList
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieCardSmall(
    modifier: Modifier = Modifier,
    movieList: MovieList,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(200.dp)
            .clickable {
                onClick()
            }
    ) {
        GlideImage(
            imageModel = { Constant.IMG_URL_POSTER + movieList.posterPath },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Fit
            ),
            loading = {
                CircularProgressIndicator()
            },
            failure = {
                ImageNotFound()
            }
        )
    }
}