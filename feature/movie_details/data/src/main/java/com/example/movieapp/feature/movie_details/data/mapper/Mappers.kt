package com.example.movieapp.feature.movie_details.data.mapper

import com.example.movieapp.core.network.model.MovieDetailsDTO
import com.example.movieapp.feature.movie_details.domain.model.MovieDetails

fun MovieDetailsDTO.toDomain(): MovieDetails {
    return MovieDetails(
        title = this.originalTitle,
        desc = this.overview,
        imageUrl = makeFullUrl(this.posterPath)
    )
}

fun makeFullUrl(path: String) = "https://image.tmdb.org/t/p/w500/${path}"