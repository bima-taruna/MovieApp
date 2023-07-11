package com.bima.movieapp.domain.use_case.get_movie

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId:String): Flow<Resource<Movie>>{
       return repository.getMovieDetail(movieId)
    }
}