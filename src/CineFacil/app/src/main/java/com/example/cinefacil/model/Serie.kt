package com.example.cinefacil.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Serie(
    @StringRes val seasonId: Int,
    @StringRes val streamingId: Int,
    @StringRes val titleId: Int,
    @DrawableRes val imageId: Int

)
