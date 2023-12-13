package com.example.cinefacil.features.movieDetails.domain.useCase

import com.example.cinefacil.features.movieDetails.domain.model.MovieDetails
import com.example.cinefacil.features.movieDetails.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class AddMovieDetails @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    suspend operator fun invoke(movieDetails: MovieDetails) =
        repository.insertMovieDetailsInDatabase(movieDetails.toDatabaseDto())
}