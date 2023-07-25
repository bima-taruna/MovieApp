package com.bima.movieapp.domain.use_case.get_popular

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularUseCase @Inject constructor(
    private val repository: MovieRepository
) {
   operator fun invoke(): Flow<Resource<List<MovieList>>>  {
        return repository.getPopularMovies()
    }
}