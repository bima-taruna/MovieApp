package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.domain.use_case.get_movie_list.GetMovieListUseCase
import com.bima.movieapp.viewmodel.state.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state
    private val type: String = checkNotNull(savedStateHandle["type"])
    private var page by mutableStateOf(1)
    private val movieList = mutableStateListOf<MovieList>()
    init {
        getMovieList()
    }

    private fun getMovieList() {
        getMovieListUseCase(type, page).onEach { result ->
            when(result) {
                is Resource.Success -> {
                        result.data?.map {
                            movieList.add(it)
                        }
                        _state.value = MoviesState(movieList = movieList)
                }
                is Resource.Error -> {
                    _state.value = MoviesState(error = result.message ?:
                    "An unexpected error occurred")
                    Log.d("test", result.message.toString())
                }
                is Resource.Loading -> {
                        _state.value = state.value.copy(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
    fun nextPage() {
        page++
        getMovieList()
    }
}
