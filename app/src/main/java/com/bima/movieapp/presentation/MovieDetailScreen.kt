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
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.common.Constant
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.presentation.components.ImageBackdrop
import com.bima.movieapp.presentation.components.ImagePoster
import com.bima.movieapp.presentation.components.NowPlayingList
import com.bima.movieapp.viewmodel.MovieDetailViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.bitmap.CenterCrop

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        state.movie?.let { movie ->
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                ConstraintLayout() {
                    val (backDrop, poster, title, overview) = createRefs()
                    val horizontalChain =
                        createHorizontalChain(poster, title, chainStyle = ChainStyle.Spread)
                    GlideImage(
                        model = Constant.IMG_URL + movie.backdropPath,
                        contentDescription = "backdrop",
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(backDrop) {}
                    )
                    Spacer(modifier = Modifier
                        .padding(8.dp)
                        .constrainAs(title) {
                            top.linkTo(backDrop.bottom)
                        })
                    Row(modifier = Modifier.constrainAs(poster) {
                        start.linkTo(parent.start)
                        top.linkTo(title.top)
                        bottom.linkTo(backDrop.bottom)
                    }) {
                        GlideImage(
                            model = Constant.IMG_URL_POSTER + movie.posterPath,
                            contentDescription = "poster",
                            modifier = Modifier
                                .height(150.dp)
                                .padding(start = 24.dp),

                            )
                        Box(modifier = Modifier.fillMaxHeight()) {
                            Text(
                                text = movie.title,
                                style = MaterialTheme.typography.titleLarge,
                                maxLines = 4,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding( start = 8.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter),
                                )
                        }
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}