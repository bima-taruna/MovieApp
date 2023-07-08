package com.bima.movieapp.data.repository

import com.bima.movieapp.common.Resource
import com.bima.movieapp.data.remote.dto.toMovie
import com.bima.movieapp.data.remote.dto.toNowPlaying
import com.bima.movieapp.data.remote.retrofit.ApiService
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override suspend fun getNowPlayingMovies(): Flow<Resource<List<NowPlaying>>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlaying = apiService.getNowPlayingMovies().map {it.toNowPlaying()}
            emit(Resource.Success(nowPlaying))
        } catch (e:HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e:IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override suspend fun getMovieDetail(movieId: String): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())
            val movie = apiService.getMovieById(movieId).toMovie()
            emit(Resource.Success(movie))
        } catch (e:HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e:IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }
}