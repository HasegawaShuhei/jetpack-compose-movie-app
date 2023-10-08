package com.example.movieapp.feature.movie.data.mapper

import com.example.movieapp.core.network.model.MovieListResponse
import com.example.movieapp.feature.movie.domain.model.Movie

fun MovieListResponse.toDomainMovieList(): List<Movie> {
    return this.results.map {
        Movie(
            it.id.toString(),
            makeFullUrl(it.posterPath)
        )
    }
}

fun makeFullUrl(path: String) = "https://image.tmdb.org/t/p/w500/${path}"