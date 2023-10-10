package com.example.movieapp.feature.movie_details.domain.di

import com.example.movieapp.feature.movie_details.domain.repository.MovieDetailsRepository
import com.example.movieapp.feature.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideGetMovieDetailsUseCase(
        movieDetailsRepo: MovieDetailsRepository,
    ): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieDetailsRepo)
    }
}