package com.example.movieapp.core.network.dataproviders

import com.example.movieapp.core.network.ApiService
import javax.inject.Inject

class MovieDataProviders @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovieList(query: String) = apiService.getMovieList(query = query)

}