package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.ApiResponse
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.NetworkResource
import com.app.muhrahmatullah.dicodingjetpackmovie.rest.Resource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
class TmdbRepository @Inject constructor(private val dataSource: RemoteDataSource) {


    fun fetchMovie(): LiveData<Resource<MovieResponse>> {
        return object: NetworkResource<MovieResponse>() {
            override fun createCall(): LiveData<ApiResponse<MovieResponse>> {
                return dataSource.fetchMovie()
            }
        }.asLiveData()
    }

    fun fetchTvSeries(): LiveData<Resource<MovieResponse>> {
        return object: NetworkResource<MovieResponse>() {
            override fun createCall(): LiveData<ApiResponse<MovieResponse>> {
                return dataSource.fetchTvSeries()
            }
        }.asLiveData()
    }


}