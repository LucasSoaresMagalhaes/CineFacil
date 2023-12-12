package com.example.cinefacil.features.movieDetails.data.repository

import com.example.cinefacil.features.movieDetails.domain.model.MovieDetails

interface MovieDetailsDto {
    fun toMovieDetails(): MovieDetails
}