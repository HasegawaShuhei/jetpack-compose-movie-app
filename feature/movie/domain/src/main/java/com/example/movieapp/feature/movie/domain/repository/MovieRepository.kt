package com.example.movieapp.feature.movie.domain.repository

import com.example.movieapp.feature.movie.domain.model.Movie

interface MovieRepository {

    suspend fun getMovieList(query: String): List<Movie>

}