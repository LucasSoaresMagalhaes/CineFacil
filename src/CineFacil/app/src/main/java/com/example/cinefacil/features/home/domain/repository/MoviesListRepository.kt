package com.example.cinefacil.features.home.domain.repository

import com.example.cinefacil.features.home.data.remote.dto.MoviesDto
import com.example.cinefacil.features.home.domain.util.ListMoviesType

interface MoviesListRepository {
    suspend fun getListMoviesByType(listMoviesType: ListMoviesType) : MoviesDto
}