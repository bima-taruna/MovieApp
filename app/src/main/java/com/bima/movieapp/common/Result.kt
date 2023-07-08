package com.bima.movieapp.common

sealed class Result<T>(
    val data:T? = null,
    val message:String? = null
) {
    class Success<T>(data:T):Result<Any?>(data)
    class Error<T>(
        message: String? = null,
        data:T? = null
    ) : Result<Any?>(data, message)

    class Loading<T>(data:T?=null) : Result<Any?>(data)
}
