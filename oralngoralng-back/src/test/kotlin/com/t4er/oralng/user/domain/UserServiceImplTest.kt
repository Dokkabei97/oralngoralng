package com.t4er.oralng.user.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceImplTest(@Autowired val userService: UserService) {

    @DisplayName("유저 생성")
    @Test
    fun create_user() {
        // given
        val command: UserCommand.RegisterUserRequest = UserCommand.RegisterUserRequest("닉네임", "이메일")

        // when
        val user = userService.createUser(command)

        // then
        assertThat(user.userToken).startsWith("usr_")
        assertThat(user.nickname).isEqualTo("닉네임")
        assertThat(user.email).isEqualTo("이메일")
        assertThat(user.status).isEqualTo(User.Status.COMMON)
    }
}