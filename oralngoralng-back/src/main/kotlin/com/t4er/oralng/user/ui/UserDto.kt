package com.t4er.oralng.user.ui

import com.t4er.oralng.user.domain.UserCommand
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserDto {

    data class CreateUserRequest(
        @NotBlank(message = "닉네임은 필수입니다.")
        var nickname: String,
        @Email(message = "이메일 형식과 다릅니다.")
        var email: String
    ) {
        companion object {
            fun toCommand(nickname: String, email: String): UserCommand.RegisterUserRequest {
                return UserCommand.RegisterUserRequest(nickname, email)
            }
        }
    }

    data class CreateUserResponse(
        var nickname: String,
        var email: String
    )
}
