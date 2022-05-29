package com.t4er.oralng.user.application

import com.t4er.oralng.user.domain.UserCommand.*
import com.t4er.oralng.user.domain.UserInfo
import com.t4er.oralng.user.domain.UserService
import org.springframework.stereotype.Service

@Service
class UserFacade(val userService: UserService) {

    fun registerUser(command: RegisterUserRequest): UserInfo {
        return userService.registerUser(command)
    }

    fun deleteUser(command: DeleteUserRequest) {
        userService.deleteUser(command)
    }

    fun getUser(command: GetUserRequest): UserInfo {
        return userService.getUser(command)
    }
}