package com.example.movieapp.feature.movie.data.di

import com.example.movieapp.core.network.dataproviders.MovieDataProviders
import com.example.movieapp.feature.movie.data.repository.MovieRepositoryImpl
import com.example.movieapp.feature.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepo(movieDataProviders: MovieDataProviders): MovieRepository {
        return MovieRepositoryImpl(movieDataProviders)
    }

}