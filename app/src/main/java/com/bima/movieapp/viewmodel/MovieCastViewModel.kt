package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Constant
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.get_movie_cast.GetMovieCastUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MovieCastViewModel @Inject constructor(
    private val getMovieCastUseCase: GetMovieCastUseCase,
    val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(MovieCastState())
    val state: State<MovieCastState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_MOVIE_ID)?.let { movieId->
            getMovieCast(movieId)
        }
    }

    private fun getMovieCast(movieId:String) {
        getMovieCastUseCase(movieId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MovieCastState(cast = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = MovieCastState(error = result.message ?:
                    "An unexpected error occurred")
                    Log.d("test", result.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = MovieCastState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}