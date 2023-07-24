package com.bima.movieapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bima.movieapp.presentation.components.ImageSwipe
import com.bima.movieapp.presentation.components.PopularMovie

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageSwipe(navController = navController)
        PopularMovie()
    }
}