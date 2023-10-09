package com.example.movieapp.feature.movie_details.domain.repository

import com.example.movieapp.feature.movie_details.domain.model.MovieDetails

interface MovieDetailsRepository {

    suspend fun getMovieDetails(id: String): MovieDetails
}