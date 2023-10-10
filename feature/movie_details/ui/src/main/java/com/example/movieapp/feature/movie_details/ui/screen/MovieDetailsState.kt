package com.example.movieapp.feature.movie_details.ui.screen

import com.example.movieapp.feature.movie_details.domain.model.MovieDetails


data class MovieDetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null,
)