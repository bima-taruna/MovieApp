package com.bima.movieapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.bima.movieapp.common.Constant
import com.bima.movieapp.viewmodel.state.MovieDetailState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    state: MovieDetailState,
) {
    state.movie?.let { movie ->
        val genresString = movie.genres?.joinToString(separator = " | ")
        Column(
            modifier = modifier
                .fillMaxHeight(0.50f)
        ) {
            ConstraintLayout {
                val (backDrop, poster, title, genres, favorite) = createRefs()
                createHorizontalChain(poster, title, chainStyle = ChainStyle.Spread)
                GlideImage(
                    imageModel = { Constant.IMG_URL + movie.backdropPath },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit
                    ),
                    loading = {
                        ImageLoading()
                    },
                    failure = {
                        ImageNotFound()
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .constrainAs(backDrop) {},
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier
                        .constrainAs(favorite) {
                            end.linkTo(backDrop.end, margin = 8.dp)
                            top.linkTo(backDrop.top, margin = 8.dp)
                        }
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "favorite button",
                        tint = MaterialTheme.colorScheme.background,
                        modifier = modifier
                            .size(80.dp)
                    )
                }
                Card(modifier = modifier
                    .height(150.dp)
                    .fillMaxWidth(0.3f)
                    .padding(start = 16.dp)
                    .constrainAs(poster) {
                        top.linkTo(title.top)
                        bottom.linkTo(title.bottom)
                    }) {

                    GlideImage(
                        imageModel = { Constant.IMG_URL_POSTER + movie.posterPath },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop
                        ),
                        loading = {
                            ImageLoading()
                        },
                        modifier = modifier
                    )
                }
                Text(
                    text = movie.title.toString(),
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
                if (genresString != null) {
                    Text(
                        text = genresString,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .padding(horizontal = 8.dp)
                            .constrainAs(genres) {
                                start.linkTo(title.start, margin = 8.dp)
                                top.linkTo(title.bottom, margin = 8.dp)
                                end.linkTo(title.end, margin = 8.dp)
                            }
                            .fillMaxWidth(0.7f)
                    )
                }


            }
        }


    }
}