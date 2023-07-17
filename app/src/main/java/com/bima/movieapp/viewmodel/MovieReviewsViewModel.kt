package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.getReview.GetMovieReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(
    private val getMovieReviewUseCase: GetMovieReviewUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MovieReviewsState())
    val state: State<MovieReviewsState> = _state

    private fun getMovieReview(movieId:String) {
        getMovieReviewUseCase(movieId).onEach { result->
            when(result) {
                is Resource.Success -> {
                    _state.value = MovieReviewsState(Reviews = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MovieReviewsState(error = result.message ?:
                    "An unexpected error occured")
                    Log.d("test", result.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = MovieReviewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}