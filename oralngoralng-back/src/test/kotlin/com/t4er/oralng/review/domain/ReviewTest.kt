package com.t4er.oralng.review.domain

import com.t4er.oralng.common.exception.InvalidParamException
import com.t4er.oralng.user.domain.User
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.Assertions.*

internal class ReviewTest : DescribeSpec({

    describe("리뷰") {
        context("작성") {
            it("성공") {
                val review = Review.of(user, "나만의 여행 추천 List Top 100", "내가 개인적으로 추천하는....")

                review.title shouldStartWith "나만의 여행"
                review.content shouldEndWith "추천하는...."
                review.likeCount shouldBe 0
                review.hitCount shouldBe 0
            }
        }
        context("작성하는데 제목이나 혹은 글 내용이 없으면") {
            it("실패") {
                shouldThrow<InvalidParamException> {
                    Review.of(user, "", "제목이 없음")
                }
                shouldThrow<InvalidParamException> {
                    Review.of(user, "내용이 없음", "")
                }
            }
        }
    }
}) {
    companion object {
        val user = User.of("홍길동", "hong@oralng.com")
    }
}