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
class UserTest {


    @Autowired
    private lateinit var userRepository: UserRepository

    @DisplayName("유저 생성")
    @Test
    fun user_create() {
        //given
        val user: User = User(1, "usr_token", "닉네임", "test@test.com", User.Status.COMMON)
        //when
        val saveUser = userRepository.save(user)
        //then
        assertThat(saveUser.userToken).startsWith("usr_")
        assertThat(saveUser.nickname).isEqualTo("닉네임")
        assertThat(saveUser.email).isEqualTo("test@test.com")
        assertThat(saveUser.status).isEqualTo(User.Status.COMMON)
    }
}