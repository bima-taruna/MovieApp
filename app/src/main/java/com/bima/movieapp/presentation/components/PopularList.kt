package com.bima.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import com.bima.movieapp.domain.model.NowPlaying
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PopularList(
    nowPlaying: NowPlaying,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            GlideImage(
                imageModel = { Constant.IMG_URL_POSTER + nowPlaying.posterPath },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Fit
                )
            )
        }
        Spacer(modifier = modifier.padding(4.dp))
        Text(
            text = nowPlaying.title.toString(),
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = modifier
                .width(120.dp)
        )
    }
}