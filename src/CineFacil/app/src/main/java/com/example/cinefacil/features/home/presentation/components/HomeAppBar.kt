package com.example.cinefacil.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinefacil.R

@Composable
fun HomeAppBar() {
    TopAppBar(
        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White
    ) {
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            modifier = Modifier.size(152.dp),
            painter = painterResource(id = R.drawable.logo_no_background),
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeAppBarPreview() {
    HomeAppBar()
}