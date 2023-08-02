package com.bima.movieapp.domain.use_case.get_searched_movie

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchedMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(query:String, page:Int): Flow<Resource<List<MovieList>>> {
        return repository.getSearchedMovie(query, page)
    }
}