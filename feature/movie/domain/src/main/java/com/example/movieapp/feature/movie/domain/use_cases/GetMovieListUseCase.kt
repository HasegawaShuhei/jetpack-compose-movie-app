package com.example.movieapp.feature.movie.domain.use_cases

import com.example.movieapp.core.common.UiEvent
import com.example.movieapp.feature.movie.domain.model.Movie
import com.example.movieapp.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke(query: String) = flow<UiEvent<List<Movie>>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(movieRepository.getMovieList(query)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}