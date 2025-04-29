package br.com.arml.devhub.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class Response <out T>{
    data class Success <out T>(val result: T): Response<T>()
    data class Failure (val exception: Exception): Response<Nothing>()
    data object Loading: Response<Nothing>()
}

fun <T> onResponse(
    databaseOperation: suspend () -> T
): Flow<Response<T>> = flow {
    emit(Response.Loading)
    try {
        emit(Response.Success(databaseOperation()))
    } catch (e: Exception) {
        emit(Response.Failure(e))
    }
}