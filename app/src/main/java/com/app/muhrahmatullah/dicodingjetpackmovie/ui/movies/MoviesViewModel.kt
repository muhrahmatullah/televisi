package com.app.muhrahmatullah.dicodingjetpackmovie.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.muhrahmatullah.dicodingjetpackmovie.data.FakeRepo
import com.app.muhrahmatullah.dicodingjetpackmovie.data.TmdbRepository
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.Entity
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.Resource
import com.app.muhrahmatullah.dicodingjetpackmovie.testing.OpenForTesting
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-09-24.
 */
@OpenForTesting
class MoviesViewModel @Inject constructor(private val repo: TmdbRepository) : ViewModel() {

    private val _movieTrigger = MutableLiveData<Boolean>()

    val data: LiveData<Resource<MovieResponse>> = Transformations.switchMap(_movieTrigger) {
        repo.fetchMovie()
    }

    fun triggerMovie() {
        _movieTrigger.value = true
    }
}