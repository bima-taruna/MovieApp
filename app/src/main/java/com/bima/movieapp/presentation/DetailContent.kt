package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModel
import com.bima.movieapp.common.Constant
import com.bima.movieapp.presentation.components.ImageLoading
import com.bima.movieapp.viewmodel.MovieDetailState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    state: MovieDetailState,
) {
    state.movie?.let { movie ->
        Column(modifier = modifier
            .fillMaxHeight(0.5f)
            ) {
            ConstraintLayout() {
                val (backDrop, poster, title, genres) = createRefs()
                createHorizontalChain(poster, title, chainStyle = ChainStyle.Spread)
                GlideImage(
                    imageModel = { Constant.IMG_URL + movie.backdropPath },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit
                    ),
                    loading = {
                        ImageLoading()
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .constrainAs(backDrop) {},
                )
                GlideImage(
                    imageModel = { Constant.IMG_URL_POSTER + movie.posterPath },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit
                    ),
                    loading = {
                        ImageLoading()
                    },
                    modifier = modifier
                        .height(150.dp)
                        .padding(start = 8.dp)
                        .constrainAs(poster) {
                            top.linkTo(title.top)
                            bottom.linkTo(title.bottom)
                        }
                )
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 4,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .width(250.dp)
                        .padding(top = 16.dp)
                        .constrainAs(title) {
                            top.linkTo(backDrop.bottom)
                        }
                )
                Row(
                    modifier = modifier
                        .constrainAs(genres) {
                            start.linkTo(title.start, margin = 8.dp)
                            top.linkTo(title.bottom, margin = 8.dp)
                            end.linkTo(title.end, margin = 8.dp)
                        }

                ) {
                    movie.genres.forEachIndexed { index, genre ->
                        val nextElement = movie.genres.elementAtOrNull(index + 1)
                        val isNextElementEmpty = nextElement.isNullOrEmpty()
                        Text(
                            text = genre,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = modifier.padding(4.dp)
                        )
                        if (!isNextElementEmpty) {
                            Text(text = "|")
                        }
                    }
                }
            }
        }
    }
}