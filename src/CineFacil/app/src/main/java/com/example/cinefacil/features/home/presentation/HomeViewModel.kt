package com.example.cinefacil.features.home.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinefacil.R
import com.example.cinefacil.features.home.domain.model.HomeSection
import com.example.cinefacil.util.NetworkErrorMessages
import com.example.cinefacil.util.Resource
import com.example.cinefacil.features.home.domain.model.Movie
import com.example.cinefacil.features.home.domain.useCase.GetMoviesList
import com.example.cinefacil.features.home.domain.util.ListMoviesType
import com.example.cinefacil.features.home.presentation.states.HomeMutableState
import com.example.cinefacil.features.home.presentation.states.HomeState
import com.example.cinefacil.features.home.presentation.states.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesList: GetMoviesList
) : ViewModel() {

    private val _homeState = HomeMutableState(
        popularMoviesListState = mutableStateOf(MoviesListState()),
        topRatedMoviesListState = mutableStateOf(MoviesListState()),
    )

    private val homeState = HomeState(
        popularMoviesListState = _homeState.popularMoviesListState,
        topRatedMoviesListState = _homeState.topRatedMoviesListState,
    )

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        for (type in ListMoviesType.values()) {
            getMovies(type)
        }
    }

    private fun getMovies(type: ListMoviesType) {
        getMoviesList(type).onEach { result ->
            when (type) {
                ListMoviesType.POPULAR -> {
                    _homeState.popularMoviesListState.value = getMoviesListState(result)
                }
                ListMoviesType.TOP_RATED -> {
                    _homeState.topRatedMoviesListState.value = getMoviesListState(result)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMoviesListState(result: Resource<List<Movie>>) = when (result) {
        is Resource.Success -> MoviesListState(movies = result.data ?: emptyList())
        is Resource.Error -> MoviesListState(
            error = result.message ?: NetworkErrorMessages.UNEXPECTED
        )
        is Resource.Loading -> MoviesListState(isLoading = true)
    }

    fun getSections() = listOf(
        HomeSection(
            textId = R.string.most_popular,
            state = homeState.popularMoviesListState.value
        ),
        HomeSection(
            textId = R.string.top_rated,
            state = homeState.topRatedMoviesListState.value,
        )
    )
}