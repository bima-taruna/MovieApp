@file:OptIn(ExperimentalGlideComposeApi::class)

package com.bima.movieapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
    state.movie?.let { movie->
        Column(modifier = Modifier, Arrangement.Center) {

//            Box(modifier = Modifier) {
//                ImageBackdrop(imageUrl = Constant.IMG_URL + movie.backdropPath)
//                Box(modifier = Modifier.fillMaxWidth().padding(top = 120.dp)) {
//                    Row() {
//                        GlideImage(model = Constant.IMG_URL_POSTER + movie.posterPath, contentDescription = "poster")
//                        Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
//                            Text(text = movie.title, modifier = Modifier.align(Alignment.BottomStart), style = MaterialTheme.typography.headlineSmall)
//                        }
//                    }
//                }
//            }
        ConstraintLayout() {
            val (backDrop,poster,title,overview) = createRefs()
            GlideImage(
                model = Constant.IMG_URL + movie.backdropPath,
                contentDescription = "backdrop",
                modifier = Modifier.fillMaxWidth().constrainAs(backDrop) {}
            )
            GlideImage(
                model = Constant.IMG_URL_POSTER + movie.posterPath,
                contentDescription = "poster",
                modifier = Modifier.height(150.dp).padding(start = 24.dp).constrainAs(poster) {
                    top.linkTo(title.top)
                    start.linkTo(backDrop.start)
                    bottom.linkTo(title.bottom)
                }.border(width = 1.dp, color = MaterialTheme.colorScheme.onPrimaryContainer, shape = RoundedCornerShape(10.dp)),

            )

            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 4,
                modifier = Modifier.padding(8.dp).width(200.dp).constrainAs(title) {
                    top.linkTo(backDrop.bottom)
                    start.linkTo(poster.end)
                } )

            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = movie.overview,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(overview){
                    top.linkTo(poster.bottom)
                })
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