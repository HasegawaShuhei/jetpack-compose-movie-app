package com.example.movieapp.feature.movie_details.domain.use_cases

import com.example.movieapp.core.common.UiEvent
import com.example.movieapp.feature.movie_details.domain.model.MovieDetails
import com.example.movieapp.feature.movie_details.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepo: MovieDetailsRepository
) {
    operator fun invoke(id: String): Flow<UiEvent<MovieDetails>> = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(movieDetailsRepo.getMovieDetails(id)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}