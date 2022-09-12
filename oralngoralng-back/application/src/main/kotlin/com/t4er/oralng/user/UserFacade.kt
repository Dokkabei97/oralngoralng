package com.t4er.oralng.user

import org.springframework.stereotype.Service
import com.t4er.oralng.user.UserCommand.*
import com.t4er.oralng.user.UserInfo
import com.t4er.oralng.user.UserService

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