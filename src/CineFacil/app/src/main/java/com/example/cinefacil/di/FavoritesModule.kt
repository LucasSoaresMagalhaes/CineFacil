package com.example.cinefacil.di

import com.example.cinefacil.features.favorites.data.repository.FavoritesRepositoryImpl
import com.example.cinefacil.features.favorites.domain.repository.FavoritesRepository
import com.example.cinefacil.features.movieDetails.data.dataSource.MovieDetailsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoritesModule {
    @Provides
    @Singleton
    fun providesFavoritesRepository(db: MovieDetailsDatabase): FavoritesRepository {
        return FavoritesRepositoryImpl(db.movieDetailsDao)
    }
}