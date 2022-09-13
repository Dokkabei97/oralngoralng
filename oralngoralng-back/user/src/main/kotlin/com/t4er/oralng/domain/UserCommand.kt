package com.t4er.oralng.domain

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserCommand {

    class RegisterUserRequest(
        @field: NotBlank(message = "nickname 은 필수 입니다.")
        val nickname: String,

        @field: NotBlank(message = "email 은 필수 입니다.")
        @field: Email(message = "이메일 형식을 맞춰 주세요.")
        val email: String,
    )

    class UpdateUserRequest(
        @field: NotNull(message = "userId 는 필수 입니다.")
        val userId: Long,
        @field: NotBlank(message = "nickname 은 필수 입니다.")
        val nickname: String,
    )

    class DeleteUserRequest(
        @field: NotNull(message = "userId 는 필수 입니다.")
        val userId: Long,
    )

    class GetUserRequest(
        @field: NotNull(message = "userId 는 필수 입니다.")
        val userId: Long,
    )
}