package com.example.movieapp.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.UiEvent
import com.example.movieapp.feature.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailsState())
    val movieDetails: State<MovieDetailsState> get() = _movieDetails

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(it)
            }
        }

    }

    fun getMovieDetails(id: String) {
        getMovieDetailsUseCase(id).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieDetails.value = MovieDetailsState(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieDetails.value = MovieDetailsState(error = it.message.toString())
                }

                is UiEvent.Success -> {
                    _movieDetails.value = MovieDetailsState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}