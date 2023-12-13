package com.example.cinefacil.features.favorites.presentation

import com.example.cinefacil.features.favorites.domain.model.FavoriteMovieModel

data class FavoriteMoviesState(
    val favorites: List<FavoriteMovieModel> = emptyList(),
    val isLoading: Boolean = true
)
