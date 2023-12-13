package com.example.cinefacil.features.home.data.remote

import com.example.cinefacil.util.ApiConstants
import com.example.cinefacil.features.home.data.remote.dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesListApi {

    @GET("movie/{type}?${ApiConstants.QUERY_DEFAULT}")
    suspend fun getListMoviesByType(@Path("type") type: String): MoviesDto

}