package com.t4er.oralng.common.exception

import com.t4er.oralng.common.response.ErrorCode

class IllegalStatusException : BaseException {

    constructor() : super(ErrorCode.COMMON_ILLEGAL_STATUS)

    constructor(message: String) : super(message, ErrorCode.COMMON_ILLEGAL_STATUS)
}