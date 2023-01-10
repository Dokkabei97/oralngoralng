package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReviewServiceImpl(val reviewReader: ReviewReader, val reviewStore: ReviewStore) : ReviewService {

    override fun create(review: CreateReviewRequest) {
        val locationTags = review.locationTags.forEach {

        }

    }

    override fun update(review: UpdateReviewRequest) {
        TODO("Not yet implemented")
    }
}