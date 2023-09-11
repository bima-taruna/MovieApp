package com.bima.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.viewmodel.state.MoviesState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun BackdropImage(
    modifier: Modifier = Modifier,
    state : Any,
    index : Int?
) {
    if (state is MoviesState) {
        GlideImage(
            imageModel = { Constant.IMG_URL + state.movieList[index!!].backdropPath },
            imageOptions = ImageOptions(
                contentScale = ContentScale.FillWidth,
                contentDescription = state.movieList[index!!].title + " image"
            ),
            failure = {
                ImageNotFound()
            },
            loading = {
                ImageLoading()
            },
            modifier = modifier
        )
    }
    if (state is Movie) {
        GlideImage(
            imageModel = { Constant.IMG_URL + state.backdropPath },
            imageOptions = ImageOptions(
                contentScale = ContentScale.FillWidth,
                contentDescription = state.title + " image"
            ),
            failure = {
                ImageNotFound()
            },
            loading = {
                ImageLoading()
            },
            modifier = modifier
        )
    }
    if (state is MoviesState) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            Color.Transparent
                        )
                    )
                )
        )
    }
}