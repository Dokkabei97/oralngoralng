package com.t4er.oralng.response

data class CommonHttpResponse<T>(
        val result: Result,
        val data: T,
        val message: String?,
        val errorCode: String?
) {
    enum class Result {
        SUCCESS, FAIL
    }

    companion object {
        fun <T> success(data: T, message: String?): CommonHttpResponse<T> {
            return CommonHttpResponse(
                    Result.SUCCESS,
                    data,
                    message,
                    null
            )
        }

        fun <T> success(data: T): CommonHttpResponse<T> {
            return success(data, null)
        }

        fun fail(message: String?, errorCode: String?): CommonHttpResponse<*> {
            return CommonHttpResponse(
                    Result.FAIL,
                    null,
                    message,
                    errorCode
            )
        }

        fun fail(errorCode: ErrorCode): CommonHttpResponse<*> {
            return CommonHttpResponse(
                    Result.FAIL,
                    errorCode.errorMessage,
                    errorCode.name,
                    null
            )
        }
    }
}