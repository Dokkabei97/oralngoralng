package com.t4er.oralng.user.domain

class UserCommand {

    class RegisterUserRequest(val nickname: String, val email: String) {
        companion object {
            fun toEntity(nickname: String, email: String): User {
                return User.of(nickname, email)
            }
        }
    }

    class UpdateUserRequest(val userToken: String, val nickname: String, val status: User.Status)

    class DeleteUserRequest(val userToken: String)

    class GetUserRequest(val userToken: String)
}