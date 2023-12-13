package com.example.cinefacil.features.home.presentation.states

import com.example.cinefacil.features.home.domain.model.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
