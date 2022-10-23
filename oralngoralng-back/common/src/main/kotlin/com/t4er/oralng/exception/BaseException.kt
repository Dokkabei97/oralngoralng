package com.t4er.oralng.exception

import com.t4er.oralng.response.ErrorCode

open class BaseException: RuntimeException {
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