package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.get_popular.GetPopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val getPopularUseCase: GetPopularUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NowPlayingState())
    val state: State<NowPlayingState> = _state

    init {
        getPopular()
    }

    private fun getPopular() {
            getPopularUseCase().onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = NowPlayingState(movieList = result.data ?: emptyList())

                    }
                    is Resource.Error -> {
                        _state.value = NowPlayingState(error = result.message ?:
                        "An unexpected error occurred")
                        Log.d("test", result.message.toString())
                    }
                    is Resource.Loading -> {
                        _state.value = NowPlayingState(isLoading = true)
                    }
                }

        }.launchIn(viewModelScope)
    }
}