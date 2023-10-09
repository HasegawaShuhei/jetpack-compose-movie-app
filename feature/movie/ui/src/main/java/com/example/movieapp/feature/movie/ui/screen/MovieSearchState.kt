package com.example.movieapp.feature.movie.ui.screen

import com.example.movieapp.feature.movie.domain.model.Movie

data class MovieSearchState(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = "",
)
