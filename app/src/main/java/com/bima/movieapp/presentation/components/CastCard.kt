package com.bima.movieapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.Cast
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CastCard(
    cast: Cast?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(16.dp)
    ) {
       GlideImage(
           imageModel = { Constant.IMG_URL + cast?.profilePath },
           imageOptions = ImageOptions(
               contentScale = ContentScale.Fit
           )
       )
       Text(text = cast?.name.toString())
       Text(text = cast?.character.toString())
    }
}