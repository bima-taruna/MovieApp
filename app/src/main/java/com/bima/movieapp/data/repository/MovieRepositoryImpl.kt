package com.bima.movieapp.data.repository

import android.util.Log
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Cast
import com.bima.movieapp.data.remote.dto.movieCastDto.toCast
import com.bima.movieapp.data.remote.dto.movieDetailDto.toMovie
import com.bima.movieapp.data.remote.dto.movieReviewsDto.toReviews
import com.bima.movieapp.data.remote.dto.nowPlayingDto.toNowPlaying
import com.bima.movieapp.data.remote.retrofit.ApiService
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.NowPlaying
import com.bima.movieapp.domain.model.Reviews
import com.bima.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override fun getNowPlayingMovies() : Flow<Resource<List<NowPlaying>>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlaying = apiService.getNowPlayingMovies(type = "now_playing").toNowPlaying()
            Log.d("success", nowPlaying.toString())
            emit(Resource.Success(nowPlaying))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }

    }

    override fun getPopularMovies(): Flow<Resource<List<NowPlaying>>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlaying = apiService.getNowPlayingMovies(type = "popular").toNowPlaying()
            Log.d("success", nowPlaying.toString())
            emit(Resource.Success(nowPlaying))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getMovieDetail(movieId: String): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())
            val movie = apiService.getMovieById(movieId).toMovie()
            emit(Resource.Success(movie))
        } catch (e:HttpException) {
            Log.d("failed", e.localizedMessage ?: "error occured")
            emit(Resource.Error(e.localizedMessage ?: "error occured"))

        } catch (e:IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getReview(movieId: String): Flow<Resource<List<Reviews>?>> = flow {
        try {
            emit(Resource.Loading())
            val review = apiService.getMovieReviews(movieId).toReviews()
            emit(Resource.Success(review))
        } catch (e:HttpException) {
            Log.d("failed", e.localizedMessage ?: "error occured")
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e:IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getMovieCast(movieId: String): Flow<Resource<List<Cast>?>> = flow {
        try {
            emit(Resource.Loading())
            val cast = apiService.getMovieCast(movieId).toCast()
            Log.d("success", cast.toString())
            emit(Resource.Success(cast))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }
}