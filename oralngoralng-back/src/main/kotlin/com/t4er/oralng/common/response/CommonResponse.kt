package com.t4er.oralng.common.response

import com.fasterxml.jackson.annotation.JsonInclude

data class CommonResponse<T>(
    val result: Result,
    val data: T,
    val message: String?,
    val errorCode: String?,
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