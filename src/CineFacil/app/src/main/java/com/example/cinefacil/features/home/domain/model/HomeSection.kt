package com.example.cinefacil.features.home.domain.model

import androidx.annotation.StringRes
import com.example.cinefacil.features.home.presentation.states.MoviesListState

data class HomeSection(
    @StringRes val textId: Int,
    val state: MoviesListState
)
