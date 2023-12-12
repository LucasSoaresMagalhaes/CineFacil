package com.example.cinefacil.features.favorites.data.repository

import com.example.cinefacil.features.favorites.domain.repository.FavoritesRepository
import com.example.cinefacil.features.movieDetails.data.dataSource.MovieDetailsDao
import com.example.cinefacil.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl(
    private val dao: MovieDetailsDao
) : FavoritesRepository {

    override fun getFavoriteMovies(): Flow<List<EntityMovieDetailsDto>> =
        dao.getAllMovieDetails()

}