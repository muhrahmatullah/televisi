package com.app.muhrahmatullah.dicodingjetpackmovie.rest

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
abstract class NetworkResource<ResultType> {

    private val result =  MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)
        @Suppress("LeakingThis")
        val apiResponse = createCall()
        result.addSource(apiResponse) {response ->
            if (response.code != -1) {
                setValue(Resource.success(response.body))
            } else {
                setValue(Resource.error(null, response.message))
            }
        }
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }


    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<ResultType>>

}