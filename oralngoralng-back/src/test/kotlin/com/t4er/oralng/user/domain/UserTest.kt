package com.t4er.oralng.user.domain

import com.t4er.oralng.user.infrastructure.UserRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class UserTest {


    @Autowired
    private lateinit var userRepository: UserRepository

    @AfterEach
    fun after() {
        userRepository.deleteAll()
    }

    @DisplayName("유저 생성")
    @Test
    fun user_create() {
        // given
        val user = User.of("닉네임", "test@test.com")
        // when
        val saveUser = userRepository.save(user)
        // then
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
        val findById = saveUser.id?.let { userRepository.findById(it) }
        assertThat(findById).isEmpty
    }

    @DisplayName("유저 조회")
    @Test
    fun user_get() {
        // given
        val user = User.of("닉네임", "test@test.com")
        val saveUser = userRepository.save(user)

        // when
        val findUser = userRepository.findById(3L)
            .orElseThrow()

        // then
        assertThat(findUser.nickname).isEqualTo("닉네임")
        assertThat(findUser.status).isEqualTo(User.Status.COMMON)
        assertThat(findUser.email).isEqualTo("test@test.com")
    }
}