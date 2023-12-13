package com.example.cinefacil.features.movieDetails.data.remote

import com.example.cinefacil.features.movieDetails.data.remote.dto.WebMovieDetailsDto
import com.example.cinefacil.features.movieDetails.data.remote.dto.videos.VideosDto
import com.example.cinefacil.util.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {

    @GET("movie/{movieId}?${ApiConstants.QUERY_DEFAULT}")
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): WebMovieDetailsDto

    @GET("movie/{movieId}/videos?${ApiConstants.QUERY_DEFAULT}")
    suspend fun getMovieVideos(@Path("movieId") movieId: Int): VideosDto
}