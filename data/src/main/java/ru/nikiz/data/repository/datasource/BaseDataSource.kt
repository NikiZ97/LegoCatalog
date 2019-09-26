package ru.nikiz.data.repository.datasource

import retrofit2.Response
import ru.nikiz.domain.Result

abstract class BaseDataSource {

    suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Result.success(it)
                }
            }
            return Result.error(response.message())
        } catch(e: Exception) {
            return Result.error(e.message)
        }
    }
}