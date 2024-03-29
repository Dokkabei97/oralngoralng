package com.t4er.oralng.application

import com.t4er.oralng.domain.UserCommand.*
import com.t4er.oralng.domain.UserInfo
import com.t4er.oralng.domain.UserService
import org.springframework.stereotype.Service

@Service
class UserFacade(val userService: UserService) {

    fun registerUser(command: RegisterUserRequest): UserInfo = userService.registerUser(command)
    fun updateUser(command: UpdateUserRequest): UserInfo = userService.updateUser(command)
    fun deleteUser(command: DeleteUserRequest) = userService.deleteUser(command)
    fun getUser(command: GetUserRequest): UserInfo = userService.getUser(command)

}