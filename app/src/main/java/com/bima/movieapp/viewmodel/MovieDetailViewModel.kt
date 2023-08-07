package com.bima.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bima.movieapp.common.Constant
import com.bima.movieapp.common.FavEvent
import com.bima.movieapp.common.Resource
import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.use_case.get_fav_note.FavMovieUseCases
import com.bima.movieapp.domain.use_case.get_movie.GetMovieUseCase
import com.bima.movieapp.viewmodel.state.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val favMovieUseCases: FavMovieUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(MovieDetailState())
    val state: MutableState<MovieDetailState> = _state

    init {

           savedStateHandle.get<String>(Constant.PARAM_MOVIE_ID)?.let { movieId->
               getMovieDetail(movieId)
           }

    }

    private fun getMovieDetail(movieId:String = "455476") {

            getMovieUseCase(movieId).onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = MovieDetailState(movie = result.data)
                        Log.d("vm", "berhasil")
                    }
                    is Resource.Error -> {
                        _state.value = MovieDetailState(error = result.message ?:
                        "An unexpected error occured")
                        Log.d("vm", "gagal")
                    }
                    is Resource.Loading -> {
                        _state.value = MovieDetailState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun onEvent(event: FavEvent) {
        when(event) {
            is FavEvent.AddMovie<*> -> {
                viewModelScope.launch {
                    val movie = Movies(
                        id = _state.value.movie?.id,
                        title = _state.value.movie?.title,
                        posterPath = Constant.IMG_URL_POSTER + _state.value.movie?.posterPath,
                        backdropPath = Constant.IMG_URL + _state.value.movie?.backdropPath,
                        voteAverage = _state.value.movie?.voteAverage as Double?,
                        releaseDate = _state.value.movie?.releaseDate
                    )
                    favMovieUseCases.addMovie(movie)
                }
            }
            is FavEvent.DeleteMovie<*> -> {
                viewModelScope.launch {
                    val movie = Movies(
                        id = _state.value.movie?.id,
                        title = _state.value.movie?.title,
                        posterPath = Constant.IMG_URL_POSTER + _state.value.movie?.posterPath,
                        backdropPath = Constant.IMG_URL + _state.value.movie?.backdropPath,
                        voteAverage = _state.value.movie?.voteAverage as Double?,
                        releaseDate = _state.value.movie?.releaseDate
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