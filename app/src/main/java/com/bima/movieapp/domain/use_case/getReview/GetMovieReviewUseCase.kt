package com.bima.movieapp.domain.use_case.getReview

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Reviews
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieReviewUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId:String): Flow<Resource<List<Reviews>?>> {
        return repository.getReview(movieId)
    }
}