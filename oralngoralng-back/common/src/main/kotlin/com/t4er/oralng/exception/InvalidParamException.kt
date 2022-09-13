package com.t4er.oralng.exception

import com.t4er.oralng.response.ErrorCode
import graphql.ErrorClassification
import graphql.ErrorType

class InvalidParamException(
    @JvmField
    @Suppress("INAPPLICABLE_JVM_FIELD")
    override val message: String? = "InvalidParam",
) : GraphqlException(ErrorCode.COMMON_INVALID_PARAMETER, message) {

    override fun getMessage(): String? {
        return super.getMessage()
    }

    override fun getErrorType(): ErrorClassification {
        return ErrorType.ValidationError
    }
}