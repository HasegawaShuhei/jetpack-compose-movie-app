package com.example.movieapp.feature.movie.data.repository

import com.example.movieapp.core.network.dataproviders.MovieDataProviders
import com.example.movieapp.feature.movie.data.mapper.toDomainMovieList
import com.example.movieapp.feature.movie.domain.model.Movie
import com.example.movieapp.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val movieDataProviders: MovieDataProviders) :
    MovieRepository {

    override suspend fun getMovieList(query: String): List<Movie> {
        return movieDataProviders.getMovieList(query).toDomainMovieList()
    }
}