package com.t4er.oralng.domain

import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
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
                        "여행 조무사",
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
                "여행 조무사",
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
                nickname = "여행 조무사",
                title = "대충 제목",
                content = "대충 리뷰 내용",
                locationTags = mutableListOf(
                    Location.SEOUL,
                    Location.GYEONGGIDO,
                    Location.INCHEON
                ),
                themeTags = mutableListOf(
                    Theme.FRIEND,
                    Theme.FOOD
                )
            )
            it("분리") {
                var themes: String = ""
                for (theme in review.themeTags) {
                    themes += theme.description + ", "
                }
                val theme = themes.substring(0, themes.length - 2)
                theme shouldBe "우정 여행, 식도락 여행"
            }
        }

        context("CreateReviewRequest") {
            val request: ReviewCommand.CreateReviewRequest =
                ReviewCommand.CreateReviewRequest(
                    userId = 1L,
                    nickname = "여행 조무사",
                    title = "대충 제목",
                    content = "대충 리뷰 내용",
                    locationTags = mutableListOf(
                        Location.SEOUL,
                        Location.GYEONGGIDO,
                        Location.INCHEON
                    ),
                    themeTags = mutableListOf(
                        Theme.FRIEND,
                        Theme.FOOD
                    )
                )
            var locations: String = ""
            for (location in request.locationTags) {
                locations += location.description + ", "
            }
            val location = locations.substring(0, locations.length - 2)
            var themes: String = ""
            for (theme in request.themeTags) {
                themes += theme.description + ", "
            }
            val theme = themes.substring(0, themes.length - 2)
            it("review") {
                val review = Review.of(
                    request.userId,
                    request.nickname,
                    request.title,
                    request.content,
                    location,
                    theme
                )

                review.themeTags shouldBe "우정 여행, 식도락 여행"
                review.locationTags shouldBe "서울, 경기도, 인천"
            }
        }
    }
})
