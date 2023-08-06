package com.bima.movieapp.domain.use_case.get_fav_note

import com.bima.movieapp.data.local.entity.Movies
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetByTitle(
    private val repository: MovieRepository
) {
    operator fun invoke(title:String) : Flow<Movies> {
       return repository.getByTitle(title)
    }
}