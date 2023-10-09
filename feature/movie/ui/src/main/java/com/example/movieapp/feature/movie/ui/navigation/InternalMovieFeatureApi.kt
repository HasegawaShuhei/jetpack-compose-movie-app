package com.example.movieapp.feature.movie.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.movieapp.core.common.navigation_constants.MovieFeature
import com.example.movieapp.core.feature_api.FeatureApi

internal object InternalMovieFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(
            startDestination = MovieFeature.movieScreenRoute,
            route = MovieFeature.nestedRoute
        ) {
            composable(MovieFeature.movieScreenRoute) {

            }
        }
    }
}