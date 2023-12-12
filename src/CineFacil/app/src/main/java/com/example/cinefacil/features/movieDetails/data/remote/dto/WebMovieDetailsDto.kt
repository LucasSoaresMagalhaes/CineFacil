package com.example.cinefacil.features.movieDetails.data.remote.dto

import com.example.cinefacil.features.movieDetails.data.remote.dto.genres.GenreDto
import com.example.cinefacil.features.movieDetails.data.repository.MovieDetailsDto
import com.example.cinefacil.features.movieDetails.domain.model.MovieDetails
import com.example.cinefacil.util.ApiConstants
import com.example.cinefacil.util.ToDomain
import com.google.gson.annotations.SerializedName

data class WebMovieDetailsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genres")
    val genres: List<GenreDto>
) : MovieDetailsDto {
    override fun toMovieDetails() = MovieDetails(
        id = id,
        title = originalTitle,
        overview = overview,
        score = (voteAverage * 10).toInt(),
        releaseDate = ToDomain.toReleaseDate(releaseDate),
        posterUrl = ApiConstants.POSTER_BASE_URL + posterPath,
        backdropUrl = ApiConstants.BACKDROP_BASE_URL + backdropPath,
        genres = genres.map { it.toGenre() }
    )
}