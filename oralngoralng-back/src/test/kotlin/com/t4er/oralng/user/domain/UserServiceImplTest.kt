package com.t4er.oralng.user.domain

import com.t4er.oralng.common.exception.EntityNotFoundException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.maps.beEmpty

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
internal class UserServiceImplTest:  BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var userService: UserService

    init {
        given("유저 서비스") {
            `when`("createUser를 호출하면") {
                val createUser = userService.createUser(
                    UserCommand.RegisterUserRequest("홍길동", "hong@test.com")
                )
                then("유저가 만들어진다") {
                    createUser.nickname shouldBe "홍길동"
                    createUser.email shouldBe "hong@test.com"
                    createUser.status shouldBe User.Status.COMMON
                }
            }
            `when`("updateUser를 호출하면") {
                val updateUser = userService.updateUser(
                    UserCommand.UpdateUserRequest(1L, "김길동")
                )
                then("유저는 홍길동에서 김길동이 된다") {
                    updateUser.nickname shouldBe "김길동"
                }
            }
            `when`("getUser를 호출하면") {
                val user = userService.getUser(
                    UserCommand.GetUserRequest(1L)
                )
                then("user가 반환된다") {
                    user.nickname shouldBe "김길동"
                    user.email shouldBe "hong@test.com"
                    user.status shouldBe User.Status.COMMON
                }
            }
            `when`("deleteUser를 호출하면") {
                userService.deleteUser(
                    UserCommand.DeleteUserRequest(1L)
                )
                then("유저는 삭제 된다") {
                    shouldThrow<EntityNotFoundException> {
                        userService.getUser(UserCommand.GetUserRequest(1L))
                    }
                }
            }

        }
    }
}