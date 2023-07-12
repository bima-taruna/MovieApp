@file:OptIn(ExperimentalGlideComposeApi::class)

package com.bima.movieapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun ImagePoster(imageUrl: String) {
    GlideImage(model = imageUrl, contentDescription = "image poster", contentScale = ContentScale.Fit)
}