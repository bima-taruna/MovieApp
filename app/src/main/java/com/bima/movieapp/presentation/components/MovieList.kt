package com.bima.movieapp.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bima.movieapp.presentation.navigation.Screen
import com.bima.movieapp.viewmodel.state.MoviesState
import kotlinx.coroutines.flow.filter

@Composable
fun MovieList(
    state:MoviesState,
    modifier: Modifier = Modifier,
    navController:NavController,
    nextPage : () -> Unit
) {
    val lazyColumnListState = rememberLazyListState()
//    val shouldStartPaginate = remember {
//        derivedStateOf {
//            lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == lazyColumnListState.layoutInfo.totalItemsCount - 1
//        }
//    }
//    Log.d("check", shouldStartPaginate.toString())
//    Log.d("check2", lazyColumnListState.firstVisibleItemIndex.toString())
//    Log.d("check3", state.movieList.lastIndex.toString())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state=lazyColumnListState
    ) {
        items(state.movieList.size, key = { it }) { i ->
            val movie = state.movieList[i]
            if (i >= state.movieList.size - 1 && !state.isLoading) {
               nextPage()
            }
            MovieListItem(
                movieList = movie,
                onItemClick = {
                    navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                })
        }
        item(){
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
//    LaunchedEffect(shouldStartPaginate) {
//        nextPage()
//        Log.d("fire", "FIRE")
//    }

}