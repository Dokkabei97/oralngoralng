package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import com.t4er.oralng.domain.ReviewStore
import org.springframework.stereotype.Component

@Component
class ReviewStoreImpl(
    val reviewRepository: ReviewRepository,
    val reviewSearchRepository: ReviewSearchRepository
) : ReviewStore {

    override fun create(review: Review): Review = reviewRepository.save(review)
    override fun delete(reviewId: Long) = reviewRepository.deleteReview(reviewId)

}