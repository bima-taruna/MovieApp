package com.bima.movieapp.data.repository

import android.util.Log
import com.bima.movieapp.common.Resource
import com.bima.movieapp.domain.model.Cast
import com.bima.movieapp.data.remote.dto.movieCastDto.toCast
import com.bima.movieapp.data.remote.dto.movieDetailDto.toMovie
import com.bima.movieapp.data.remote.dto.movieReviewsDto.toReviews
import com.bima.movieapp.data.remote.dto.movieListDto.toMovieList
import com.bima.movieapp.data.remote.retrofit.ApiService
import com.bima.movieapp.domain.model.Movie
import com.bima.movieapp.domain.model.MovieList
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
    override fun getNowPlayingMovies() : Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlaying = apiService.getMovies(type = "now_playing").toMovieList()
            Log.d("success", nowPlaying.toString())
            emit(Resource.Success(nowPlaying))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }

    }

    override fun getPopularMovies(): Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val popular = apiService.getMovies(type = "popular").toMovieList()
            Log.d("success", popular.toString())
            emit(Resource.Success(popular))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getTopRatedMovies(): Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val topRated = apiService.getMovies(type = "top_rated").toMovieList()
            Log.d("success", topRated.toString())
            emit(Resource.Success(topRated))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getUpcomingMovies(): Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val upcoming = apiService.getMovies(type = "upcoming").toMovieList()
            Log.d("success", upcoming.toString())
            emit(Resource.Success(upcoming))
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

    override fun getMovieList(type: String): Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = apiService.getMovies(type = type).toMovieList()
            Log.d("success", movies.toString())
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }

    override fun getSearchedMovie(query: String): Flow<Resource<List<MovieList>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = apiService.searchMovie(query = query).toMovieList()
            Log.d("success", movies.toString())
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server, please check your internet connection" ))
        }
    }
}