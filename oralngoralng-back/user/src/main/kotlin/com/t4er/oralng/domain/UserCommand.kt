package com.t4er.oralng.domain

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank


class UserCommand {

    class RegisterUserRequest(
        @field: NotBlank(message = "nickname 은 필수 입니다.")
        val nickname: String,
        @field: NotBlank(message = "email 은 필수 입니다.")
        @field: Email(message = "이메일 형식을 맞춰 주세요.")
        val email: String,
    )

    class UpdateUserRequest(
        val userId: Long,
        @field: NotBlank(message = "nickname 은 필수 입니다.")
        val nickname: String,
    )

    class DeleteUserRequest(
        val userId: Long,
    )

    class GetUserRequest(
        val userId: Long,
    )
}