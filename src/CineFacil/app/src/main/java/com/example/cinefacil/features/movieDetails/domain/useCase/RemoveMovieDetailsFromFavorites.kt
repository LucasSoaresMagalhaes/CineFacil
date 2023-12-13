package com.example.cinefacil.features.movieDetails.domain.useCase

import com.example.cinefacil.features.movieDetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject


class RemoveMovieDetailsFromFavorites @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    suspend operator fun invoke(id: Int) = repository.removeMovieDetailsFromDatabaseById(id)
}