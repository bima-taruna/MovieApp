package com.bima.movieapp.domain.use_case.get_now_playing

import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.NowPlaying
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNPlayingUseCase @Inject constructor(
    private val repository: MovieRepository
) {
   suspend operator fun invoke(): Flow<Resource<List<NowPlaying>>> {
        return repository.getNowPlayingMovies()
    }
}