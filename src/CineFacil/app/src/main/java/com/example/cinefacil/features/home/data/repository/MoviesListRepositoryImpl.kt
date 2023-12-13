package com.example.cinefacil.features.home.data.repository

import com.example.cinefacil.features.home.data.remote.MoviesListApi
import com.example.cinefacil.features.home.data.remote.dto.MoviesDto
import com.example.cinefacil.features.home.domain.util.ListMoviesType
import com.example.cinefacil.features.home.domain.repository.MoviesListRepository
import javax.inject.Inject

class MoviesListRepositoryImpl @Inject constructor(
    private val api: MoviesListApi
) : MoviesListRepository {

    override suspend fun getListMoviesByType(listMoviesType: ListMoviesType): MoviesDto =
        api.getListMoviesByType(listMoviesType.value)
}