package com.t4er.oralng.user.domain

import com.t4er.oralng.common.exception.InvalidParamException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.inspectors.forAny
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class UserTest : DescribeSpec({

    describe("유저") {
        context("닉네임이 13글자 이상이면") {
            it("InvalidParamException 이 터진다") {
                shouldThrow<InvalidParamException> {
                    User.of(nickname, "test@test.com")
                }
            }
        }

        context("유저 생성") {
            it("성공") {
                val user = User.of("홍길동", "hong@test.com")
                user.nickname shouldBe "홍길동"
                user.email shouldBe "hong@test.com"
            }
        }
    }
}) {
    companion object {
        const val nickname: String = "최강전사파워킹갓오토제너럴123"
    }
}
