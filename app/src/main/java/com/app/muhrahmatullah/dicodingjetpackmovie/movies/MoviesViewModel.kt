package com.app.muhrahmatullah.dicodingjetpackmovie.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.muhrahmatullah.dicodingjetpackmovie.data.FakeRepo
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieEntity
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-09-24.
 */
class MoviesViewModel @Inject constructor(private val fakeRepo: FakeRepo): ViewModel() {

    private val _movieTrigger = MutableLiveData<Boolean>()

    val movieTrigger: LiveData<Boolean>
        get() = _movieTrigger

    val movieData : LiveData<List<MovieEntity>> = Transformations.switchMap(_movieTrigger) {
        fakeRepo.fetchMovie()
    }

    fun triggerMovie() {
        _movieTrigger.value = true
    }

}