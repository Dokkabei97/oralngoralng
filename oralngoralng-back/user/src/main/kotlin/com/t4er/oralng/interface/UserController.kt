package com.t4er.oralng.`interface`

import com.t4er.oralng.application.UserFacade
import com.t4er.oralng.domain.UserCommand.*
import com.t4er.oralng.domain.UserInfo
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(val userFacade: UserFacade) {

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @MutationMapping
    fun registerUser(@Argument @Valid input: RegisterUserRequest): UserInfo = userFacade.registerUser(input)

    @MutationMapping
    fun updateUser(@Argument @Valid input: UpdateUserRequest): UserInfo = userFacade.updateUser(input)

    @MutationMapping
    fun deleteUser(@Argument @Valid input: DeleteUserRequest) = userFacade.deleteUser(input)

    @QueryMapping
    fun getUser(@Argument @Valid input: GetUserRequest): UserInfo = userFacade.getUser(input)

}