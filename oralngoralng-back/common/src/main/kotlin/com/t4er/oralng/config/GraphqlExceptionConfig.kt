package com.t4er.oralng.config

import com.t4er.oralng.exception.EntityNotFoundException
import com.t4er.oralng.exception.InvalidParamException
import graphql.GraphQLError
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter

@Configuration
class GraphqlExceptionConfig: DataFetcherExceptionResolverAdapter() {

    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? {
        return when (ex) {
            is EntityNotFoundException -> EntityNotFoundException(ex.message)
            is InvalidParamException -> InvalidParamException(ex.message)
            else ->  super.resolveToSingleError(ex, env)
        }
    }
}