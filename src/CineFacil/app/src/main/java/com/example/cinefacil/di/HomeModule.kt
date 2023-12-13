package com.example.cinefacil.di

import com.example.cinefacil.util.ApiConstants
import com.example.cinefacil.features.home.data.remote.MoviesListApi
import com.example.cinefacil.features.home.data.repository.MoviesListRepositoryImpl
import com.example.cinefacil.features.home.domain.repository.MoviesListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideMoviesListApi(): MoviesListApi = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesListApi::class.java)

    @Provides
    @Singleton
    fun provideMoviesListRepository(api: MoviesListApi): MoviesListRepository =
        MoviesListRepositoryImpl(api)
}