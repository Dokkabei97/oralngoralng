package com.t4er.oralng.user.domain

import com.t4er.oralng.user.domain.UserCommand.*

interface UserService {
    fun registerUser(command: RegisterUserRequest): UserInfo
    fun updateUser(command: UpdateUserRequest): UserInfo
    fun deleteUser(command: DeleteUserRequest)
    fun getUser(command: GetUserRequest): UserInfo
}