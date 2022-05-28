package com.t4er.oralng.user.ui

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.nio.charset.StandardCharsets


@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
): DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    companion object {
        const val URI = "/api/v1/users"
    }

    init {
        describe("유저 컨트롤러") {
            context("유서 생성 API") {
                val dto: UserDto.RegisterUserRequest = UserDto.RegisterUserRequest("닉네임", "test@test.com")
                val requestBuilder = MockMvcRequestBuilders.post(URI)
                    .content(objectMapper.writeValueAsString(dto))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .characterEncoding(StandardCharsets.UTF_8.displayName())
                it("성공") {
                    mockMvc.perform(requestBuilder)
                        .andExpect(MockMvcResultMatchers.status().isOk)
                        .andExpect(MockMvcResultMatchers.jsonPath("\$.nickname").value("닉네임"))
                        .andExpect(MockMvcResultMatchers.jsonPath("\$.email").value("test@test.com"))
                }
            }
        }
    }
}