

package com.bima.movieapp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bima.movieapp.common.Constant
import com.bima.movieapp.common.FavEvent
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.PopularViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSwipe(
    modifier: Modifier = Modifier,
    viewModel: PopularViewModel = hiltViewModel(),
    navController: NavController,
) {
    val state = viewModel.state.value
    val pagerState = rememberPagerState()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.55f)
    ) {
        HorizontalPager(
            pageCount = state.movieList.size,
            state = pagerState,
        ) { index ->
            ConstraintLayout {
                val (backDrop, title, buttonRow, spacer) = createRefs()
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .constrainAs(backDrop) {}
                ) {
                    Column {
                        GlideImage(
                            imageModel = { Constant.IMG_URL + state.movieList[index].backdropPath },
                            imageOptions = ImageOptions(
                                contentScale = ContentScale.Fit,
                                contentDescription = state.movieList[index].title + " image"
                            ),
                            failure = {
                               ImageNotFound()
                            },
                            loading = {
                                ImageLoading()
                            }
                        )
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

                Text(
                    text = state.movieList[index].title.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .constrainAs(title) {
                            start.linkTo(spacer.start)
                            bottom.linkTo(spacer.top)
                        }
                )

                Spacer(modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(spacer) {
                        start.linkTo(backDrop.start)
                        end.linkTo(backDrop.end)
                        bottom.linkTo(backDrop.bottom)
                    })
                Row(
                    modifier = modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.background
                                )
                            )
                        )
                        .padding(8.dp)
                        .fillMaxWidth()

                        .constrainAs(buttonRow) {
                            start.linkTo(spacer.start)
                            end.linkTo(spacer.end)
                            top.linkTo(spacer.bottom)
                            bottom.linkTo(backDrop.bottom)
                        },
                ) {
                    BigButton(
                        buttonText = "Add to Wishlist",
                        onClick = {
                                  viewModel.onEvent(FavEvent.AddMovie(state.movieList[index]), index)
                        },
                        icon = Icons.Default.FavoriteBorder,
                        modifier = modifier.weight(1f)
                    )
                    BigButton(
                        buttonText = "Detail",
                        modifier = modifier.weight(1f),
                        icon = null,
                        onClick = {
                            navController.navigate(Screen.MovieDetailScreen.route + "/${state.movieList[index].id}")
                        })
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    textAlign = TextAlign.Justify,
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
}

