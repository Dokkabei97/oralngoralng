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
        // given
        val user = User.of("닉네임", "test@test.com")
        // when
        val saveUser = userRepository.save(user)
        // then
        assertThat(saveUser.userToken).startsWith("usr_")
        assertThat(saveUser.nickname).isEqualTo("닉네임")
        assertThat(saveUser.email).isEqualTo("test@test.com")
        assertThat(saveUser.status).isEqualTo(User.Status.COMMON)
    }

    @DisplayName("유저 수정")
    @Test
    fun user_update() {
        // given
        val user = User.of("닉네임", "test@test.com")
        val saveUser = userRepository.save(user)
        // when
        saveUser.update("홍길동", User.Status.MEMBERSHIP1)
        // then
        assertThat(saveUser.nickname).isEqualTo("홍길동")
        assertThat(saveUser.status).isEqualTo(User.Status.MEMBERSHIP1)

        assertThat(saveUser.nickname).isNotEqualTo("닉네임")
        assertThat(saveUser.status).isNotEqualTo(User.Status.COMMON)
    }

    @DisplayName("유저 삭제")
    @Test
    fun user_delete() {
        // given
        val user = User.of("닉네임", "test@test.com")
        val saveUser = userRepository.save(user)

        // when
        saveUser.id?.let { userRepository.deleteById(it) }
        userRepository.flush()

        // then
        val findById = userRepository.findById(1L)
        assertThat(findById).isEmpty
    }

    @DisplayName("유저 조회")
    @Test
    fun user_get() {
        // given
        val user = User.of("닉네임", "test@test.com")
        val saveUser = userRepository.save(user)

        // when
        val findByUserToken = userRepository.findByUserToken(saveUser.userToken)

        // then
        assertThat(findByUserToken.userToken).startsWith("usr_")
        assertThat(findByUserToken.nickname).isEqualTo("닉네임")
        assertThat(findByUserToken.status).isEqualTo(User.Status.COMMON)
        assertThat(findByUserToken.email).isEqualTo("test@test.com")
        assertThat(findByUserToken.id).isEqualTo(1L)

        assertThat(findByUserToken.nickname).isNotEqualTo("홍길동")
        assertThat(findByUserToken.status).isNotEqualTo(User.Status.ADMIN)
        assertThat(findByUserToken.email).isNotEqualTo("hong@test.com")
    }
}