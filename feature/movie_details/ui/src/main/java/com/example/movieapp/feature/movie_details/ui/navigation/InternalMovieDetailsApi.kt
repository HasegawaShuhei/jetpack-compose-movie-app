package com.example.movieapp.feature.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.movieapp.core.common.navigation_constants.MovieDetailsFeature
import com.example.movieapp.core.feature_api.FeatureApi
import com.example.movieapp.feature.movie_details.ui.screen.MovieDetailsScreen
import com.example.movieapp.feature.movie_details.ui.screen.MovieDetailsViewModel

internal object InternalMovieDetailsApi : FeatureApi {

    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(
            route = MovieDetailsFeature.nestedRoute,
            startDestination = MovieDetailsFeature.movieDetailsScreenRoute
        ) {
            composable(MovieDetailsFeature.movieDetailsScreenRoute) {
                val id = it.arguments?.getString("id")
                val viewModel: MovieDetailsViewModel = hiltViewModel()
                MovieDetailsScreen(id = id.toString(), viewModel = viewModel)
            }
        }
    }
}