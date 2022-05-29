package com.t4er.oralng.user.ui

import com.t4er.oralng.user.domain.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserDto {

    data class RegisterUserRequest(
        @field: NotBlank
        val nickname: String,
        @field: NotBlank
        @field: Email
        val email: String
        )
    data class UpdateUserRequest(val userId: Long, val nickname: String)
    data class DeleteUserRequest(val userId: Long)
    data class GetUserRequest(val userId: Long)
    data class UserResponse(var nickname: String, var email: String, var status: User.Status)
}