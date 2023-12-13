package com.example.cinefacil.features.movieDetails.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinefacil.features.movieDetails.presentation.components.appBar.MovieDetailsAppBar
import com.example.cinefacil.features.movieDetails.presentation.content.MovieDetailsNormalConnection
import com.example.cinefacil.ui.components.BackAppBar
import com.example.cinefacil.ui.components.ScreenWithErrorConnection
import com.example.cinefacil.util.TestTags

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Scaffold(
        topBar = {
            state.value.movieDetails?.let {
                MovieDetailsAppBar(
                    filled = viewModel.favoriteState.value,
                    backClick = { navController.popBackStack() },
                    favoriteIconClick = { viewModel.favoriteClick() }
                )
            } ?: BackAppBar(
                title = null,
                backAction = { navController.popBackStack() }
            )
        }
    ) {
        MovieDetailsScreenContent(
            state = viewModel.state,
            retryButtonClick = { viewModel.getMovieDetails() },
            openYoutubeLink = { viewModel.openYoutubeVideo(it) }
        )
    }
}


@Composable
private fun MovieDetailsScreenContent(
    state: State<MovieDetailsState>,
    retryButtonClick: () -> Unit,
    openYoutubeLink: (String) -> Unit
) {
    if (state.value.error.isNotBlank()) {
        ScreenWithErrorConnection(
            retryButtonClick = retryButtonClick,
            modifier = Modifier.testTag(TestTags.MOVIE_DETAILS_SCREEN)
        )
    } else {
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        val movieDetails = state.value.movieDetails
        if (state.value.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag(TestTags.MOVIE_DETAILS_SCREEN),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .testTag(TestTags.MOVIE_DETAILS_SCREEN)
            ) {
                movieDetails?.let {
                    MovieDetailsNormalConnection(
                        screenHeight = screenHeight,
                        movieDetails = it,
                        openYoutubeLink = { videoId ->
                            openYoutubeLink(videoId)
                        }
                    )
                }
            }
        }
    }
}
