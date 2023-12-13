package com.example.cinefacil.features.home.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinefacil.features.home.domain.model.Movie
import com.example.cinefacil.features.home.presentation.components.HomeAppBar
import com.example.cinefacil.features.home.presentation.components.movieCard.MovieCard
import com.example.cinefacil.features.home.presentation.states.MoviesListState
import com.example.cinefacil.navigation.Route
import com.example.cinefacil.ui.components.ScreenWithErrorConnection
import com.example.cinefacil.ui.components.SectionTitle
import com.example.cinefacil.util.TestTags

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = modifier.testTag(TestTags.HOME_SCREEN),
        topBar = { HomeAppBar() }
    ) {
        HomeContent(navController, viewModel)
    }
}

@ExperimentalMaterialApi
@Composable
private fun HomeContent(
    navController: NavController,
    viewModel: HomeViewModel,
) {
    val sections = viewModel.getSections()
    if (sections[0].state.error.isBlank()) {
        LazyColumn(
            modifier = Modifier.padding(start = 16.dp),
        ) {
            itemsIndexed(sections) { index, item ->
                VerticalSpacer()
                SectionTitle(textId = item.textId)
                VerticalSpacer(height = 8.dp)
                MoviesRowContainer(
                    state = item.state,
                    navController = navController,
                    rowIndex = index
                )
            }
            item {
                VerticalSpacer()
            }
        }
    } else {
        ScreenWithErrorConnection(
            retryButtonClick = {
                viewModel.getAllMovies()
            }
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun MoviesRowContainer(state: MoviesListState, navController: NavController, rowIndex: Int) {
    if (state.isLoading) {
        LoadingMoviesListRow()
    } else {
        MoviesListRow(
            state.movies,
            navController,
            rowIndex
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun LoadingMoviesListRow() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        repeat(10) {
            item {
                MovieCard(
                    movie = null,
                    onClick = {}
                )
                HorizontalSpacer()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MoviesListRow(movies: List<Movie>, navController: NavController, rowIndex: Int) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(movies) { index, item ->
            MovieCard(
                modifier = Modifier.testTag("${TestTags.HOME_MOVIE_CARD} $rowIndex $index"),
                movie = item,
                onClick = { navController.navigate(Route.Details.getDynamicRoute(item.id)) }
            )
            HorizontalSpacer()
        }
    }
}


@Composable
private fun VerticalSpacer(height: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
private fun HorizontalSpacer(width: Dp = 16.dp) {
    Spacer(modifier = Modifier.width(width))
}
