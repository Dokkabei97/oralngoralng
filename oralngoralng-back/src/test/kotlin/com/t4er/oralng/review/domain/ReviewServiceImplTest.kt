package com.t4er.oralng.review.domain

import com.t4er.oralng.review.infrastructure.ReviewRepository
import com.t4er.oralng.user.domain.User
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.junit.jupiter.api.Assertions.*

internal class ReviewServiceImplTest : BehaviorSpec({
    val reviewService = mockk<ReviewService>()

    given("리뷰 서비스") {
        `when`("리뷰 작성을 하면") {
//            every { reviewService.createReview() } returns review
            then("리뷰가 생긴다") {
//                verify(exactly = 1) { reviewService.createReview() }
            }
        }
    }
}) {
    companion object {
        val review = Review.of(1L, "일산 맛집 리스트", "일산에 이렇게....")
    }
}