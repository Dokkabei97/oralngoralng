package com.t4er.oralng.common.response

class CommonResponse<T>(
    result: Result?,
    data: T?,
    message: String?,
    errorCode: String?,
) {
    companion object {
        fun <T> success(data: T, message: String?): CommonResponse<T> {
            return CommonResponse(
                result = Result.SUCCESS,
                data = data,
                message = message,
                errorCode = null
            )
        }

        fun <T> success(data: T): CommonResponse<T> {
            return success(data, null)
        }

        fun fail(message: String?, errorCode: String?): CommonResponse<*> {
            return CommonResponse(
                result = Result.FAIL,
                data = null,
                message = message,
                errorCode = errorCode
            )
        }

        fun fail(errorCode: ErrorCode): CommonResponse<*> {
            return CommonResponse(
                result = Result.FAIL,
                message = errorCode.errorMessage,
                errorCode = errorCode.name,
                data = null
            )
        }
    }

    enum class Result {
        SUCCESS, FAIL
    }
}