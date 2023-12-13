package com.example.cinefacil.features.movieDetails.presentation

import com.example.cinefacil.features.movieDetails.domain.model.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null,
    val error: String = "",
)
