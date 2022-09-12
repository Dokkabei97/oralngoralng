package com.t4er.oralng.user

import com.t4er.oralng.user.UserCommand.*

interface UserService {
    fun registerUser(command: RegisterUserRequest): UserInfo
    fun updateUser(command: UpdateUserRequest): UserInfo
    fun deleteUser(command: DeleteUserRequest)
    fun getUser(command: GetUserRequest): UserInfo
}