package com.t4er.oralng.response

import graphql.ErrorClassification
import graphql.ErrorType

enum class ErrorType : ErrorClassification {
    EntityNotFound, InvalidParam, IllegalStatus
}