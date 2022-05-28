package com.t4er.oralng.user.ui

import com.t4er.oralng.user.domain.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserDto {

    class RegisterUserRequest(
        @NotBlank
        val nickname: String,
        @NotBlank
        @Email
        val email: String
        )
    class UpdateUserRequest(val userId: Long, val nickname: String)
    class DeleteUserRequest(val userId: Long)
    class GetUserRequest(val userId: Long)
    class UserResponse(val nickname: String, val email: String, val status: User.Status)
}