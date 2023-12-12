package com.example.cinefacil.features.movieDetails.data.dataSource.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cinefacil.features.favorites.domain.model.FavoriteMovieModel
import com.example.cinefacil.features.movieDetails.data.repository.MovieDetailsDto
import com.example.cinefacil.features.movieDetails.domain.model.Genre
import com.example.cinefacil.features.movieDetails.domain.model.MovieDetails
import com.example.cinefacil.features.movieDetails.domain.model.MovieVideo
import com.example.cinefacil.util.ApiConstants
import com.example.cinefacil.util.Converters
import com.example.cinefacil.util.ToDomain

@Entity
data class EntityMovieDetailsDto(
    @PrimaryKey val id: Int,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val score: Int,
    val overview: String,
    val backdropPath: String?,
    val genres: String,
    val favorite: Boolean,
    val videoSite: String?,
    val youtubeVideoId: String?
) : MovieDetailsDto {

    override fun toMovieDetails() = MovieDetails(
        id = id,
        title = title,
        score = score,
        releaseDate = ToDomain.toReleaseDate(releaseDate),
        overview = overview,
        posterUrl = ApiConstants.POSTER_BASE_URL + posterPath,
        backdropUrl = ApiConstants.BACKDROP_BASE_URL + backdropPath,
        genres = Converters.jsonToList(genres).map { Genre(it) },
        favorite = favorite,
        movieVideo = videoSite?.let { videoSite ->
            youtubeVideoId?.let { videoId ->
                MovieVideo(site = videoSite, id = videoId)
            }
        }
    )

    fun toFavoriteMovieModel() = FavoriteMovieModel(
        id = id,
        title = title,
        image = ApiConstants.POSTER_BASE_URL + posterPath
    )

}