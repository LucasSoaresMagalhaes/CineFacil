package com.example.cinefacil.features.movieDetails.data.remote.dto.videos

import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("results")
    val result: List<VideoDto>
) {
    fun toVideos() = result.map {
        it.toVideo()
    }
}