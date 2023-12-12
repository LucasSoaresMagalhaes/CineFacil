package com.example.cinefacil.features.movieDetails.data.remote.dto.genres

import com.example.cinefacil.features.movieDetails.domain.model.Genre
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("name")
    val name: String
) {
    fun toGenre() = Genre(
        name = name
    )
}