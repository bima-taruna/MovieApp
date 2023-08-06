package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Constant
import com.bima.movieapp.common.FavEvent
import com.bima.movieapp.common.Resource
import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.use_case.get_fav_note.FavMovieUseCases
import com.bima.movieapp.domain.use_case.get_popular.GetPopularUseCase
import com.bima.movieapp.viewmodel.state.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val getPopularUseCase: GetPopularUseCase,
    private val favMovieUseCases: FavMovieUseCases
) : ViewModel() {
    private val _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state
    init {
        getPopular()
    }
    private fun getPopular() {
            getPopularUseCase().onEach { result ->
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

    fun onEvent(event:FavEvent,index:Int) {
        when(event) {
            is FavEvent.AddMovie -> {
                viewModelScope.launch {
                    val movie = Movies(
                        id = _state.value.movieList[index].id,
                        title = _state.value.movieList[index].title,
                        posterPath = Constant.IMG_URL_POSTER + _state.value.movieList[index].posterPath,
                        backdropPath = Constant.IMG_URL + _state.value.movieList[index].backdropPath,
                        voteAverage = _state.value.movieList[index].voteAverage as Double?,
                        releaseDate = _state.value.movieList[index].releaseDate
                    )
                    favMovieUseCases.addMovie(movie)
                }
            }
            is FavEvent.DeleteMovie -> {
                viewModelScope.launch {
                    val movie = Movies(
                        id = _state.value.movieList[index].id,
                        title = _state.value.movieList[index].title,
                        posterPath = Constant.IMG_URL_POSTER + _state.value.movieList[index].posterPath,
                        backdropPath = Constant.IMG_URL + _state.value.movieList[index].backdropPath,
                        voteAverage = _state.value.movieList[index].voteAverage as Double?,
                        releaseDate = _state.value.movieList[index].releaseDate
                    )
                    favMovieUseCases.deleteMovie(movie)
                }
            }
        }
    }

    fun getByTitle(title:String) : Flow<Movies> {
        return favMovieUseCases.getByTitle(title)
    }
}