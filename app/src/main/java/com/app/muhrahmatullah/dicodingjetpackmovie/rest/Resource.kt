package com.app.muhrahmatullah.dicodingjetpackmovie.rest

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
class Resource<T>(val status: Status,
               val data: T?,
               val message: String?) {

    companion object {
        fun <T> success(data: T?) : Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String?) : Resource<T>{
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?) : Resource<T>{
            return Resource(Status.LOADING, data, null)
        }
    }

}