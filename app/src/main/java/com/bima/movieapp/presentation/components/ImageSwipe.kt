@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.bima.movieapp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.common.Constant
import com.bima.movieapp.viewmodel.NowPlayingViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImageSwipe(
    modifier: Modifier = Modifier,
    viewModel: NowPlayingViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val pagerState = rememberPagerState()

    Box(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.55f)
    ) {
        HorizontalPager(
            pageCount = state.nowPlaying.size,
            state = pagerState,
        ) {index ->
            ConstraintLayout() {
                val (backDrop, title, buttonRow, spacer) = createRefs()
                GlideImage(
                    imageModel = { Constant.IMG_URL + state.nowPlaying[index].backdropPath },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit,
                        contentDescription = state.nowPlaying[index].title + " image"
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .constrainAs(backDrop) {}
                )
                Text(
                    text = state.nowPlaying[index].title.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.background,
                    modifier = modifier.constrainAs(title) {
                        start.linkTo(spacer.start)

                        bottom.linkTo(spacer.top)
                    }
                )
                Spacer(modifier = modifier.fillMaxWidth().padding(24.dp).constrainAs(spacer){
                    start.linkTo(backDrop.start)
                    end.linkTo(backDrop.end)
                    bottom.linkTo(backDrop.bottom)
                })
                Row(modifier = modifier
                    .background(MaterialTheme.colorScheme.background.copy(alpha = 0.6f))
                    .padding(16.dp)
                    .fillMaxWidth()
                    .constrainAs(buttonRow) {
                        start.linkTo(spacer.start)
                        end.linkTo(spacer.end)
                        top.linkTo(spacer.bottom)
                        bottom.linkTo(backDrop.bottom)
                    }
                ) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "add to wishlist")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "detail")
                    }
                }
            }
        }
    }
}