package com.example.movieapp.navigation

import com.example.movieapp.feature.movie.ui.navigation.MovieApi
import com.example.movieapp.feature.movie_details.ui.navigation.MovieDetailsApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi,

    )
