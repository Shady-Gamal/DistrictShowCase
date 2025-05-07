package bosta.android_task.domain.model

sealed class Resource<T>(val data: T? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null, code: Int? = null) : Resource<T>(data, throwable)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}