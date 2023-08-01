package com.bima.movieapp.domain.use_case.get_movie_list

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Cast
import com.bima.movieapp.domain.model.MovieList
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(type:String, page:Int): Flow<Resource<List<MovieList>>> {
        return repository.getMovieList(type, page)
    }
}