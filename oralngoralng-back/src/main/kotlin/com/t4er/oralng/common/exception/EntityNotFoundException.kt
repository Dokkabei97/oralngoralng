package com.t4er.oralng.common.exception

import com.t4er.oralng.common.response.ErrorCode

class EntityNotFoundException : BaseException {

    constructor() : super(ErrorCode.COMMON_ENTITY_NOT_FOUND)

    constructor(message: String) : super(message, ErrorCode.COMMON_ENTITY_NOT_FOUND)
}