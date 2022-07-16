package com.t4er.oralng.review.domain

import com.t4er.oralng.common.exception.InvalidParamException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith

internal class ReviewTest : DescribeSpec({

    describe("리뷰") {
        context("작성") {
            it("성공") {
                val review = Review.of(1L, "나만의 여행 추천 List Top 100", "내가 개인적으로 추천하는....", null)

                review.title shouldStartWith "나만의 여행"
                review.content shouldEndWith "추천하는...."
                review.likeCount shouldBe 0
                review.hitCount shouldBe 0
            }
        }
        context("작성하는데 제목이나 혹은 글 내용이 없으면") {
            it("실패") {
                shouldThrow<InvalidParamException> {
                    Review.of(1L, "", "제목이 없음", null)
                }
                shouldThrow<InvalidParamException> {
                    Review.of(1L, "내용이 없음", "", null)
                }
            }
        }
        context("이미지 json 타입 체크") {
            var image = HashMap<String, Any>()
            image.put(
                "images", mapOf("imageName" to "1.png")
            )
            it("성공"){
                val review = Review.of(1L, "나만의 여행 추천 List Top 100", "내가 개인적으로 추천하는....", image)

                println(review.image?.get("images"))
            }
        }
    }
})