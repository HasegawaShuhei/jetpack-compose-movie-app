package com.example.movieapp.feature.movie.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.core.common.UiEvent
import com.example.movieapp.feature.movie.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
) : ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchState())
    val movieList: State<MovieSearchState> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    fun setQuery(value: String) {
        _query.value = value
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(it)
            }
        }
    }

    fun getMovieList(query: String) = viewModelScope.launch {

        getMovieListUseCase(query).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieList.value = MovieSearchState(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieList.value = MovieSearchState(error = it.message.toString())
                }

                is UiEvent.Success -> {
                    _movieList.value = MovieSearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}