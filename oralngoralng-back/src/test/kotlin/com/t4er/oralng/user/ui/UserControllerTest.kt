package com.t4er.oralng.user.ui

import com.fasterxml.jackson.databind.ObjectMapper
import com.t4er.oralng.user.application.UserFacade
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.nio.charset.StandardCharsets

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {
    companion object {
        const val URI = "/api/v1/users"
    }

    @DisplayName("유저 생성 api")
    @Test
    fun create_user() {
        val dto: UserDto.CreateUserDto = UserDto.CreateUserDto("닉네임", "test@test.com")

        val requestBuilder = MockMvcRequestBuilders.post(URI)
            .content(objectMapper.writeValueAsString(dto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8.displayName())

        mockMvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk)

        // TODO: 2022-05-15 테스트 코드 더 검증 필요
    }
}