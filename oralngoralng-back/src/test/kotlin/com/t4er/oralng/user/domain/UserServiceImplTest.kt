package com.t4er.oralng.user.domain

import com.t4er.oralng.user.infrastructure.UserRepository
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

        assertThat(user.nickname).isEqualTo("닉네임")
        assertThat(user.email).isEqualTo("이메일")
        assertThat(user.status).isEqualTo(User.Status.COMMON)
    }

    @DisplayName("유정 수정")
    @Test
    fun update_user() {
        // given
        val command: UserCommand.RegisterUserRequest = UserCommand.RegisterUserRequest("닉네임", "이메일")
        val user = userService.createUser(command)
        val updateCommand = UserCommand.UpdateUserRequest(1L, "테스트", User.Status.MEMBERSHIP1)

        // when
        val updateUser = userService.updateUser(updateCommand)

        // then
        assertThat(updateUser.nickname).isEqualTo("테스트")
        assertThat(updateUser.status).isEqualTo(User.Status.MEMBERSHIP1)

        assertThat(updateUser.nickname).isNotEqualTo("닉네임")
        assertThat(updateUser.status).isNotEqualTo(User.Status.COMMON)
    }

    @DisplayName("유저 조회")
    @Test
    fun user_get() {
        // given
        val command: UserCommand.RegisterUserRequest = UserCommand.RegisterUserRequest("닉네임", "이메일")
        val user = userService.createUser(command)

        // when
        val get = userService.getUser(command = UserCommand.GetUserRequest(2L))

        // then

        assertThat(get.nickname).isEqualTo("닉네임")
        assertThat(get.email).isEqualTo("이메일")
        assertThat(get.status).isEqualTo(User.Status.COMMON)
    }

}