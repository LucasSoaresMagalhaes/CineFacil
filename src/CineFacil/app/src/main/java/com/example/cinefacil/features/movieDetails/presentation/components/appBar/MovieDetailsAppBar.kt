package com.example.cinefacil.features.movieDetails.presentation.components.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinefacil.R
import com.example.cinefacil.ui.components.BackIcon

@Composable
fun MovieDetailsAppBar(
    filled: Boolean,
    backClick: () -> Unit,
    favoriteIconClick: () -> Unit
) {
    TopAppBar(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackIcon(backAction = backClick, color = Color.White)
            FavoriteIconButton(filled = filled, favoriteClick = favoriteIconClick)
        }
    }
}

@Composable
private fun FavoriteIconButton(
    filled: Boolean,
    favoriteClick: () -> Unit
) {
    FavoriteIcon(
        favoriteClick = {
            favoriteClick()
        },
        starIconId = if (filled) {
            R.drawable.ic_star
        } else {
            R.drawable.ic_star_border
        }
    )
}

@Composable
@Preview
private fun MovieDetailsAppBarPreview() {
    MovieDetailsAppBar(
        filled = false,
        backClick = {},
        favoriteIconClick = {}
    )
}