package com.bima.movieapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.get_now_playing.GetNPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val getNowPlayingUseCase: GetNPlayingUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NowPlayingState())
    val state: State<NowPlayingState> = _state

    init {
        getNowPlaying()
    }

    private fun getNowPlaying() {
        viewModelScope.launch {
            getNowPlayingUseCase().onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = NowPlayingState(nowPlaying = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = NowPlayingState(error = result.message ?:
                        "An unexpected error occured")
                    }
                    is Resource.Loading -> {
                        _state.value = NowPlayingState(isLoading = true)
                    }
                }
            }
        }
    }
}