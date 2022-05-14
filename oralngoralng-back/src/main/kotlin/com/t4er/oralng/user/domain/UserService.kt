package com.t4er.oralng.user.domain

interface UserService {
    fun createUser(command: UserCommand.RegisterUserRequest): UserInfo
}