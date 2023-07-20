package com.bima.movieapp.domain.use_case.get_movie_cast

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Cast
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieCastUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId:String): Flow<Resource<List<Cast>?>> {
        return repository.getMovieCast(movieId)
    }
}