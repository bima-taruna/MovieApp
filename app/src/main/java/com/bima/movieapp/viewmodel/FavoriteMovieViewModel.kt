package com.bima.movieapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.FavEvent
import com.bima.movieapp.domain.use_case.get_fav_note.FavMovieUseCases
import com.bima.movieapp.domain.use_case.get_fav_note.GetFavMovieUseCase
import com.bima.movieapp.viewmodel.state.FavState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val favMovieUseCase: FavMovieUseCases
) : ViewModel() {

    private val _state = mutableStateOf<FavState>(FavState())
    val state: State<FavState> = _state

    fun onEvent(event:FavEvent) {
        when(event) {
            is FavEvent.AddMovie -> {

            }
            is FavEvent.DeleteMovie -> {
                viewModelScope.launch {

                }
            }
        }
    }

    fun getFavorite() {
        favMovieUseCase.getFav()
    }
}