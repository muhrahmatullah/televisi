package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.ApiResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.testing.OpenForTesting
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 2019-10-12.
 */
@OpenForTesting
class RemoteDataSource @Inject constructor(private val rest: MovieRest) {
    fun fetchMovie(): LiveData<ApiResponse<MovieResponse>> {
        return rest.fetchMovie()
    }

    fun fetchTvSeries(): LiveData<ApiResponse<MovieResponse>> {
        return rest.fetchTvSeries()
    }

}