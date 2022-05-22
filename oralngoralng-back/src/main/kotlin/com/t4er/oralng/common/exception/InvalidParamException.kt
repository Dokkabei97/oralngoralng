package com.t4er.oralng.common.exception

import com.t4er.oralng.common.response.ErrorCode

class InvalidParamException : BaseException {

    constructor() : super(ErrorCode.COMMON_INVALID_PARAMETER)

    constructor(errorCode: ErrorCode) : super(errorCode)

    constructor(errorMessage: String) : super(errorMessage, ErrorCode.COMMON_INVALID_PARAMETER)

    constructor(message: String, errorCode: ErrorCode) : super(message, errorCode)
}