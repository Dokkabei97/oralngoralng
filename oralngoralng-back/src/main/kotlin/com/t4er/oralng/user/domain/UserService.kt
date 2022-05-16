package com.t4er.oralng.user.domain

interface UserService {
    fun createUser(command: UserCommand.RegisterUserRequest): UserInfo
    fun updateUser(command: UserCommand.UpdateUserRequest): UserInfo
    fun deleteUser(command: UserCommand.DeleteUserRequest)
    fun getUser(command: UserCommand.GetUserRequest): UserInfo
}