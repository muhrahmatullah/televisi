package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.ApiResponse
import retrofit2.http.GET

/**
 * Created by muhrahmatullah on 2019-10-12.
 */
interface MovieRest {

    @GET("movie/popular")
    fun fetchMovie(): LiveData<ApiResponse<MovieResponse>>

    @GET("tv/popular")
    fun fetchTvSeries(): LiveData<ApiResponse<MovieResponse>>

}