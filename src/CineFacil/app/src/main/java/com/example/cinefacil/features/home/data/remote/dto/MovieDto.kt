package com.example.cinefacil.features.home.data.remote.dto


import com.example.cinefacil.features.home.domain.model.Movie
import com.example.cinefacil.util.ApiConstants
import com.example.cinefacil.util.ToDomain
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
) {
    fun toMovie() = Movie(
        id = id,
        title = originalTitle,
        score = (voteAverage * 10).toInt(),
        releaseDate = ToDomain.toReleaseDate(releaseDate),
        imageUrl = ApiConstants.POSTER_BASE_URL + posterPath
    )

}