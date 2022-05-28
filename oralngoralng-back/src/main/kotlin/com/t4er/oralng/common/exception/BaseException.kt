package com.t4er.oralng.common.exception

import com.t4er.oralng.common.response.ErrorCode

open class BaseException : RuntimeException {
    var errorCode: ErrorCode? = null

    constructor() {}
    constructor(errorCode: ErrorCode) : super(errorCode.errorMessage) {
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode: ErrorCode, cause: Throwable?) : super(message, cause) {
        this.errorCode = errorCode
    }
}