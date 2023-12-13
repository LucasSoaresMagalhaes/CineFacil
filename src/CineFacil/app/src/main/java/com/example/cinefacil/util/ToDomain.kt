package com.example.cinefacil.util

import com.example.cinefacil.features.home.domain.model.ReleaseDate

object ToDomain {
    fun toReleaseDate(releaseDate: String): ReleaseDate {
        val releaseDateSplit = releaseDate.split("-")
        val day = releaseDateSplit[2].toInt()
        val month = releaseDateSplit[1].toInt()
        val year = releaseDateSplit[0].toInt()
        return ReleaseDate(
            day = day,
            month = month,
            year = year
        )
    }
}