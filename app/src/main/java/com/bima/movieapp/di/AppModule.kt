package com.bima.movieapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bima.movieapp.BuildConfig
import com.bima.movieapp.common.Constant
import com.bima.movieapp.data.local.database.MoviesDatabase
import com.bima.movieapp.data.remote.retrofit.ApiService
import com.bima.movieapp.data.repository.DataStoreRepositoryImpl
import com.bima.movieapp.data.repository.MovieRepositoryImpl
import com.bima.movieapp.domain.repository.DataStoreRepository
import com.bima.movieapp.domain.repository.MovieRepository
import com.bima.movieapp.domain.use_case.get_fav_movie.AddMovie
import com.bima.movieapp.domain.use_case.get_fav_movie.DeleteMovie
import com.bima.movieapp.domain.use_case.get_fav_movie.FavMovieUseCases
import com.bima.movieapp.domain.use_case.get_fav_movie.GetByTitle
import com.bima.movieapp.domain.use_case.get_fav_movie.GetFavMovieUseCase
import com.bima.movieapp.domain.use_case.ui_mode.GetUiMode
import com.bima.movieapp.domain.use_case.ui_mode.SetUiMode
import com.bima.movieapp.domain.use_case.ui_mode.UiModeUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", BuildConfig.API_KEY)
                .build()
            return@Interceptor chain.proceed(request)
        }

        OkHttpClient
            .Builder()
            .addInterceptor(requestInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesDatabase(app:Application): MoviesDatabase {
        return Room.databaseBuilder(
            app,
            MoviesDatabase::class.java,
            MoviesDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(client: OkHttpClient) : ApiService {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: ApiService, db:MoviesDatabase): MovieRepository {
        return MovieRepositoryImpl(apiService, db.moviesDao)
    }

    @Provides
    @Singleton
    fun provideMovieUseCases(repository: MovieRepository): FavMovieUseCases {
        return FavMovieUseCases(
            getFav = GetFavMovieUseCase(repository),
            deleteMovie = DeleteMovie(repository),
            addMovie = AddMovie(repository),
            getByTitle = GetByTitle(repository)
        )
    }

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext app: Context
    ): DataStoreRepository {
        return DataStoreRepositoryImpl(app)
    }

    @Provides
    @Singleton
    fun provideUiDataStore(repository: DataStoreRepository): UiModeUsesCases {
        return UiModeUsesCases(
            getUiMode = GetUiMode(repository),
            setUiMode = SetUiMode(repository)
        )
    }
}