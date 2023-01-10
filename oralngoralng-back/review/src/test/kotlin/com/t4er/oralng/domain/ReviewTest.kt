package com.t4er.oralng.domain

import com.t4er.oralng.exception.InvalidParamException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ReviewTest : DescribeSpec({

    describe("리뷰 게시판 작성") {
        context("제목이 30글자가 넘어가면") {
            it("InvalidParamException이 터진다") {
                shouldThrow<InvalidParamException> {
                    Review.of(
                        1L,
                        "가나다라abcd1234가나다라abcd1234가나다라abcd1234가나다라abcd1234가나다라abcd1234",
                        "대충 내용",
                        "서울 은평구, 서울 마포구",
                        "FAMILY, HEALING"
                    )
                }
            }
        }

        context("이미지 생성") {
            val review = Review.of(
                1L,
                "홍대 투어",
                "홍대 어쩌구 ...",
                "서울 마포구 ...",
                "FRIEND, ..."
            )
            it("이미지 등록") {
                val image = mutableListOf<Image>(
                    Image.of(review, "1.png", "/1.png"),
                    Image.of(review, "2.png", "/2.png"),
                    Image.of(review, "3.png", "/3.png")
                )

                image[0].imageName shouldBe "1.png"
            }
        }

        context("태그 배열 분리") {

            val review = ReviewCommand.CreateReviewRequest(
                userId = 1L,
                title = "대충 제목",
                content = "대충 리뷰 내용",
                locationTags = mutableListOf(

                ),
                themeTags = mutableListOf(

                )
            )

            it("분리") {

            }
        }
    }
})
