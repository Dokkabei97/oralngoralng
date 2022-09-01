package com.t4er.oralng.review.domain

import com.t4er.oralng.review.infrastructure.ReviewRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.*

internal class ReviewServiceImplTest : BehaviorSpec({
    val reviewService = mockk<ReviewService>()
    val reviewRepository = mockk<ReviewRepository>()

    given("리뷰 서비스") {
        `when`("리뷰 작성을 하면") {
//            reviewService.createReview()
            then("리뷰가 생긴다") {
//                verify(exactly = 1) { reviewRepository.save(review) }
            }
        }
    }
}) {
    companion object {
        val review = Review.of(1L, "일산 맛집 리스트", "일산에 이렇게....", null)
    }
}