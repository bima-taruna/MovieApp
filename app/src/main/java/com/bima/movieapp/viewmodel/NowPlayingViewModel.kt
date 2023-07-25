package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.get_now_playing.GetNPlayingUseCase
import com.bima.movieapp.viewmodel.state.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val getNPlayingUseCase: GetNPlayingUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    init {
        getNowPlaying()
    }

    private fun getNowPlaying() {
            getNPlayingUseCase().onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = MoviesState(movieList = result.data ?: emptyList())

                    }
                    is Resource.Error -> {
                        _state.value = MoviesState(error = result.message ?:
                        "An unexpected error occurred")
                        Log.d("test", result.message.toString())
                    }
                    is Resource.Loading -> {
                        _state.value = MoviesState(isLoading = true)
                    }
                }

        }.launchIn(viewModelScope)
    }
}