@file:OptIn(ExperimentalComposeUiApi::class)

package com.bima.movieapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.bima.movieapp.viewmodel.SearchedMovieViewModel


@Composable
fun SearchBar(
    viewModel: SearchedMovieViewModel = hiltViewModel(),
) {
    var text by rememberSaveable { mutableStateOf(viewModel.query) }
    val localKeyboard = LocalSoftwareKeyboardController.current

    SearchField(text = text, onChange = { if(it.length <= 30) text = it; viewModel.query = it}, keyboard = localKeyboard) {
        viewModel.getSearchMovie()
    }

}