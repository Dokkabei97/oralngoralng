package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*
import com.t4er.oralng.domain.tag.Location
import com.t4er.oralng.domain.tag.Theme
import com.t4er.oralng.infrastructure.ReviewRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ReviewServiceImplTest : BehaviorSpec() {

    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var reviewService: ReviewService

    @Autowired
    private lateinit var reviewRepository: ReviewRepository

    init {
        given("리뷰 테스트") {
            val request: CreateReviewRequest =
                CreateReviewRequest(
                    userId = 1L,
                    nickname = "여행 조무사",
                    title = "대충 제목",
                    content = "대충 리뷰 내용",
                    images = mutableListOf<ReviewCommand.ImageRequest>(
                        ReviewCommand.ImageRequest(
                            "https://oralng.minio.com/reviews/1/image1.png",
                            "홍대 가족 여행 ..."
                        ),
                        ReviewCommand.ImageRequest(
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
            `when`("리뷰 생성") {
                val review = reviewService.create(request)
                then("성공") {
                    review.reviewId shouldBe 1L
                    review.images[0].description shouldStartWith "홍대"
                    review.title shouldBe "대충 제목"
                    review.locationTags shouldStartWith "서울"
                }
            }
        }
    }
}
