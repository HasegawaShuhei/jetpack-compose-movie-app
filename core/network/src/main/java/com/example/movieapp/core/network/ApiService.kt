package com.example.movieapp.core.network

import com.example.movieapp.core.network.model.MovieDetailsDTO
import com.example.movieapp.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = BuildConfig.apiKey,
        @Query("query") query: String,
    ): MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = BuildConfig.apiKey,
    ): MovieDetailsDTO
}