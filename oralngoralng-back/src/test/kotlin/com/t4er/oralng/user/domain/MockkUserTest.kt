package com.t4er.oralng.user.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class MockkUserTest : BehaviorSpec({
    val userCommand = mockk<UserCommand.RegisterUserRequest>()
    val userInfo = mockk<UserInfo>()
    val userService = mockk<UserService>()

    given("유저 서비스 mockk") {
        `when`("createUser 호출 mockk") {
           every { userService.registerUser(any()) } returns userInfo
            userService.registerUser(userCommand)
            then("유저 생성 mockk") {
                verify { userService.registerUser(any()) }
            }
        }
    }
})