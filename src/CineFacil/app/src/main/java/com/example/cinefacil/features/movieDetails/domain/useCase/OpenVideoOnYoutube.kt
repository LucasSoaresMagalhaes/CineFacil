package com.example.cinefacil.features.movieDetails.domain.useCase

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.cinefacil.util.ApiConstants
import javax.inject.Inject

class OpenVideoOnYoutube @Inject constructor(
    private val context: Context
) {
    operator fun invoke(videoId: String) {
        val intentBrowser =
            Intent(Intent.ACTION_VIEW, Uri.parse(ApiConstants.YOUTUBE_BASE_URL + videoId))
        context.startActivity(intentBrowser)
    }
}