package com.t4er.oralng.user.application

import com.t4er.oralng.user.domain.UserCommand
import com.t4er.oralng.user.domain.UserInfo
import com.t4er.oralng.user.domain.UserService
import org.springframework.stereotype.Service

@Service
class UserFacade(val userService: UserService) {

    fun createUser(command: UserCommand.RegisterUserRequest): UserInfo {
        return userService.createUser(command)
    }
}