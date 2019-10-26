package com.app.muhrahmatullah.dicodingjetpackmovie.rest

import retrofit2.Response

/**
 * Created by muh.rahmatullah on 2019-10-26.
 */
class ApiResponse<T>(
    val code: Int = 0,
    val body: T? = null,
    val message: String? = null
){
  companion object {
      fun <T> create(response: Response<T>): ApiResponse<T> {
          return if (response.isSuccessful) {
              val body = response.body()
              ApiResponse(response.code(), body, null)
          } else {
              ApiResponse(response.code(), null, "request failed")
          }
      }

      fun <T> create(error: Throwable): ApiResponse<T> {
          return ApiResponse(-1, null, error.message ?: "unknown error")
      }
  }
}