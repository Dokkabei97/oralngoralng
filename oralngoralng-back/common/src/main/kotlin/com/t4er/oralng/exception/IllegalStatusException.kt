package com.t4er.oralng.exception

import com.t4er.oralng.response.ErrorCode
import com.t4er.oralng.response.ErrorType
import graphql.ErrorClassification


class IllegalStatusException(
    @JvmField
    @Suppress("INAPPLICABLE_JVM_FIELD")
    override val message: String? = "IllegalStatus",
) : GraphqlException(ErrorCode.COMMON_ILLEGAL_STATUS, message) {
    override fun getMessage(): String? {
        return super.getMessage()
    }

    override fun getErrorType(): ErrorClassification {
        return ErrorType.IllegalStatus
    }
}