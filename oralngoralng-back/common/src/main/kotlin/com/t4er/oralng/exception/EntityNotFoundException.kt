package com.t4er.oralng.exception

import com.t4er.oralng.response.ErrorCode
import com.t4er.oralng.response.ErrorType
import graphql.ErrorClassification


class EntityNotFoundException(
    @JvmField
    @Suppress("INAPPLICABLE_JVM_FIELD")
    override val message: String? = "EntityNotFound",
) : GraphqlException(ErrorCode.COMMON_ENTITY_NOT_FOUND, message) {

    override fun getMessage(): String? {
        return super.getMessage()
    }

    override fun getErrorType(): ErrorClassification {
        return ErrorType.EntityNotFound
    }
}