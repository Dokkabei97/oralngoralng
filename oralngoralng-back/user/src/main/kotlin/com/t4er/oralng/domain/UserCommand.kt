package com.t4er.oralng.domain

class UserCommand {

    class RegisterUserRequest(val nickname: String, val email: String)

    class UpdateUserRequest(val userId: Long, val nickname: String)

    class DeleteUserRequest(val userId: Long)

    class GetUserRequest(val userId: Long)
}