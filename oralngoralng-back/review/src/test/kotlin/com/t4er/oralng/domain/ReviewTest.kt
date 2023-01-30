package com.t4er.oralng.domain

import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import com.t4er.oralng.exception.InvalidParamException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

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
                        hashMapOf(
                            Pair(
                                "images", listOf(
                                    hashMapOf(
                                        Pair("url", "https://oralng.minio.com/reviews/1/image1.png"),
                                        Pair("depscrion", "홍대 가족 여행 ...")
                                    ),
                                    hashMapOf(
                                        Pair("url", "https://oralng.minio.com/reviews/1/image2.png"),
                                        Pair("depscrion", "은평구 힐링 ...")
                                    ),
                                )
                            )
                        ),
                        "서울 은평구, 서울 마포구",
                        "FAMILY, HEALING"
                    )
                }
            }
        }

        context("태그 배열 분리") {

            val review = ReviewCommand.CreateReviewRequest(
                userId = 1L,
                nickname = "여행 조무사",
                title = "대충 제목",
                content = "대충 리뷰 내용",
                images = mutableListOf<ReviewCommand.Image>(
                    ReviewCommand.Image(
                        "https://oralng.minio.com/reviews/1/image1.png",
                        "홍대 가족 여행 ..."
                    ),
                    ReviewCommand.Image(
                        "https://oralng.minio.com/reviews/1/image2.png",
                        "은평구 힐링 ..."
                    )
                ),
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
                    images = mutableListOf<ReviewCommand.Image>(
                        ReviewCommand.Image(
                            "https://oralng.minio.com/reviews/1/image1.png",
                            "홍대 가족 여행 ..."
                        ),
                        ReviewCommand.Image(
                            "https://oralng.minio.com/reviews/1/image2.png",
                            "은평구 힐링 ..."
                        )
                    ),
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

            val images: MutableMap<String, List<MutableMap<String, String>>> = HashMap()
//            for ((i, v) in request.images.withIndex()) {
//                images["image$i"] = hashMapOf(
//                    Pair("imageUrl", v.url),
//                    Pair("imageDescription", v.description)
//                )
//            }
            val im: List<MutableMap<String, String>> = request.images.stream()
                .map {
                    hashMapOf(
                        Pair("url", it.url),
                        Pair("description", it.description)
                    )
                }
                .toList()
            images["images"] = im

            it("review") {
                val review = Review.of(
                    request.userId,
                    request.nickname,
                    request.title,
                    request.content,
                    images,
                    location,
                    theme
                )

                review.themeTags shouldBe "우정 여행, 식도락 여행"
                review.locationTags shouldBe "서울, 경기도, 인천"
//                review.images["images"]?.get("description") shouldStartWith "홍대"
                review.images.get("images")?.get(0)?.get("description") shouldStartWith "홍대"
            }
        }
    }
})
