@file:OptIn(ExperimentalGlideComposeApi::class)

package com.bima.movieapp.presentation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.presentation.components.NowPlayingList
import com.bima.movieapp.viewmodel.MovieDetailViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.bitmap.CenterCrop

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailViewModel = hiltViewModel(),

    ) {
    val state = viewModel.state.value
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        state.movie?.let { movie ->
            Column(modifier = modifier.verticalScroll(rememberScrollState())) {
                ConstraintLayout() {
                    val (backDrop, poster, title, genres) = createRefs()
                    createHorizontalChain(poster,title, chainStyle = ChainStyle.Spread)
                    GlideImage(
                        model = Constant.IMG_URL + movie.backdropPath,
                        contentDescription = "backdrop",
                        modifier = modifier
                            .fillMaxWidth()
                            .constrainAs(backDrop) {}
                    )
                    GlideImage(
                        model = Constant.IMG_URL_POSTER + movie.posterPath,
                        contentDescription = "poster",
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
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }

    }
}