package com.t4er.oralng.user.ui

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
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

    @DisplayName("유저 생성 api 성공")
    @Test
    fun create_user_success() {
        val dto: UserDto.CreateUserRequest = UserDto.CreateUserRequest("닉네임", "test@test.com")

        val requestBuilder = MockMvcRequestBuilders.post(URI)
            .content(objectMapper.writeValueAsString(dto))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8.displayName())

        mockMvc.perform(requestBuilder)
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.nickname").value("닉네임"))
            .andExpect(jsonPath("\$.email").value("test@test.com"))
    }


}