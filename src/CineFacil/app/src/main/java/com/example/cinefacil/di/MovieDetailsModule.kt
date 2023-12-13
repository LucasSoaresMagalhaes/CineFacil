package com.example.cinefacil.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.cinefacil.features.movieDetails.data.dataSource.MovieDetailsDatabase
import com.example.cinefacil.features.movieDetails.data.remote.MovieDetailsApi
import com.example.cinefacil.features.movieDetails.data.repository.MovieDetailsRepositoryImpl
import com.example.cinefacil.features.movieDetails.domain.repository.MovieDetailsRepository
import com.example.cinefacil.features.movieDetails.domain.useCase.AddMovieDetails
import com.example.cinefacil.features.movieDetails.domain.useCase.DetailUseCases
import com.example.cinefacil.features.movieDetails.domain.useCase.GetMovieDetails
import com.example.cinefacil.features.movieDetails.domain.useCase.GetMovieVideo
import com.example.cinefacil.features.movieDetails.domain.useCase.OpenVideoOnYoutube
import com.example.cinefacil.features.movieDetails.domain.useCase.RemoveMovieDetailsFromFavorites
import com.example.cinefacil.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsModule {

    @Provides
    @Singleton
    fun provideMovieDetailsApi(): MovieDetailsApi = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieDetailsApi::class.java)

    @Provides
    @Singleton
    fun provideMovieDetailsDatabase(app: Application): MovieDetailsDatabase {
        return Room.databaseBuilder(
            app,
            MovieDetailsDatabase::class.java,
            MovieDetailsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        api: MovieDetailsApi,
        db: MovieDetailsDatabase
    ): MovieDetailsRepository =
        MovieDetailsRepositoryImpl(api, db.movieDetailsDao)

    @Provides
    @Singleton
    fun provideOpenYoutubeVideoUseCase(@ApplicationContext context: Context) =
        OpenVideoOnYoutube(context)

    @Provides
    @Singleton
    fun provideUseCases(repository: MovieDetailsRepository, openVideoOnYoutube: OpenVideoOnYoutube): DetailUseCases {
        return DetailUseCases(
            getMovieDetails = GetMovieDetails(repository, GetMovieVideo(repository)),
            addMovieDetails = AddMovieDetails(repository),
            openVideoOnYoutube = openVideoOnYoutube,
            removeMovieDetailsFromFavorites = RemoveMovieDetailsFromFavorites(repository)
        )
    }
}