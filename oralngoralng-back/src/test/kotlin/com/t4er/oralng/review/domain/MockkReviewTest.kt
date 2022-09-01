package com.t4er.oralng.review.domain

import com.t4er.oralng.review.infrastructure.ReviewRepository
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.*

internal class MockkReviewTest : DescribeSpec({

    val reviewRepository = mockk<ReviewRepository>()

    describe("리뷰 mockk") {
        context("조회 mockk") {
            it("성공 mockk") {
                every { reviewRepository.findById(1L) } returns Optional.of(review)
            }
        }
    }
}) {
    companion object {
        val review: Review = Review(
            1L,
            1L,
            "리뷰 mockk",
            "리뷰 내용 mockk",
            null,
            0,
            0,
            Review.Status.NEW
        )
    }
}