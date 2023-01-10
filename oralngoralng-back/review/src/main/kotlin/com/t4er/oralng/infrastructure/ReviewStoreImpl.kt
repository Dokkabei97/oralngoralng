package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import com.t4er.oralng.domain.ReviewStore
import org.springframework.stereotype.Component

@Component
class ReviewStoreImpl(val reviewRepository: ReviewRepository) : ReviewStore {

    override fun create(review: Review) {
        reviewRepository.save(review)
    }
}