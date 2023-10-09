package com.example.movieapp.feature.movie_details.data.repository

import com.example.movieapp.core.network.dataproviders.MovieDataProviders
import com.example.movieapp.feature.movie_details.data.mapper.toDomain
import com.example.movieapp.feature.movie_details.domain.model.MovieDetails
import com.example.movieapp.feature.movie_details.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders,
) : MovieDetailsRepository {
    override suspend fun getMovieDetails(id: String): MovieDetails {
        return movieDataProviders.getMovieDetails(id).toDomain()
    }
}