package com.t4er.oralng.user.domain

import com.t4er.oralng.common.exception.InvalidParamException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.inspectors.forAny
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
    }
}) {
    companion object {
        const val nickname: String = "최강전사파워킹갓오토제너럴123"
    }
}
