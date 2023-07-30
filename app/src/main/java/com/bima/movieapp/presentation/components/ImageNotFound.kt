package com.bima.movieapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.bima.movieapp.R

@Composable
fun ImageNotFound(
    modifier :Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.no_image_placeholder),
        contentDescription = "default backdrop",
        contentScale = ContentScale.Fit,
        modifier = modifier.fillMaxHeight(0.6f)
    )
}