package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.ApiResponse
import retrofit2.http.GET

/**
 * Created by muhrahmatullah on 2019-10-12.
 */
interface MovieRest {

    @GET("movie/now_playing")
    fun fetchMovie(): LiveData<ApiResponse<MovieResponse>>

}