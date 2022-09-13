package com.t4er.oralng.`interface`

import org.slf4j.LoggerFactory
import com.t4er.oralng.application.UserFacade
import com.t4er.oralng.domain.UserCommand
import com.t4er.oralng.domain.UserCommand.*
import com.t4er.oralng.domain.UserInfo
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController(val userFacade: UserFacade) {

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @MutationMapping
    fun registerUser(@Argument @Validated input: RegisterUserRequest): UserInfo {
        return userFacade.registerUser(input)
    }

    @MutationMapping
    fun updateUser(@Argument @Validated input: UpdateUserRequest): UserInfo {
        return userFacade.updateUser(input)
    }

    @MutationMapping
    fun deleteUser(@Argument @Validated input: DeleteUserRequest) {
        userFacade.deleteUser(input)
    }

    @GetMapping
    fun getUser(@Argument @Validated input: GetUserRequest): UserInfo {
        return userFacade.getUser(input)
    }
}