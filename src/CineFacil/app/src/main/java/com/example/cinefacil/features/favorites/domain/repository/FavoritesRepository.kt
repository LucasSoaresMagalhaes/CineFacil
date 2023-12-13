package com.example.cinefacil.features.favorites.domain.repository

import com.example.cinefacil.features.movieDetails.data.dataSource.dto.EntityMovieDetailsDto
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavoriteMovies(): Flow<List<EntityMovieDetailsDto>>
}