package com.example.movieapp.di

import com.example.movieapp.feature.movie.ui.navigation.MovieApi
import com.example.movieapp.feature.movie_details.ui.navigation.MovieDetailsApi
import com.example.movieapp.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailsApi: MovieDetailsApi,
    ): NavigationProvider {
        return NavigationProvider(movieApi, movieDetailsApi)
    }

}