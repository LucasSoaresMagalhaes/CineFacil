package com.example.cinefacil.data

import com.example.cinefacil.R
import com.example.cinefacil.model.Serie

class Datasource() {
    fun loadSeries(): List<Serie> {
        return listOf<Serie>(
            Serie(seasonId = R.string.serie_season1, streamingId = R.string.serie_streaming1, titleId = R.string.serie_title1, imageId = R.drawable.image1),
            Serie(seasonId = R.string.serie_season2, streamingId = R.string.serie_streaming2, titleId = R.string.serie_title2, imageId = R.drawable.image2),
            Serie(seasonId = R.string.serie_season3, streamingId = R.string.serie_streaming3, titleId = R.string.serie_title3, imageId = R.drawable.image3)
        )
    }
}
