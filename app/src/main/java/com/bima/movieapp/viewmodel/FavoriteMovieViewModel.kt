package com.bima.movieapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.domain.use_case.get_fav_note.FavMovieUseCases
import com.bima.movieapp.viewmodel.state.FavState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val favMovieUseCase: FavMovieUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FavState())
    val state: State<FavState> = _state

    init {
        getFavorite()
    }

   private fun getFavorite() {
        favMovieUseCase.getFav().onEach {
            _state.value = state.value.copy(
                movies = it
            )
        }.launchIn(viewModelScope)
    }
}