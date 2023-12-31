package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Constant
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.use_case.getReview.GetMovieReviewUseCase
import com.bima.movieapp.viewmodel.state.MovieReviewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(
    private val getMovieReviewUseCase: GetMovieReviewUseCase,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(MovieReviewsState())
    val state: State<MovieReviewsState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_MOVIE_ID)?.let { movieId->
            getMovieReview(movieId)
        }
    }

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