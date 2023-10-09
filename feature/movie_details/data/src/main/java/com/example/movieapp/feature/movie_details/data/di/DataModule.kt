package com.example.movieapp.feature.movie_details.data.di

import com.example.movieapp.core.network.dataproviders.MovieDataProviders
import com.example.movieapp.feature.movie_details.data.repository.MovieDetailsRepositoryImpl
import com.example.movieapp.feature.movie_details.domain.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideMovieDetailsRepository(
        movieDataProviders: MovieDataProviders,
    ): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(movieDataProviders)
    }
}