package com.t4er.oralng.review.domain

import com.t4er.oralng.user.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReviewServiceImpl(val reviewReader: ReviewReader, val reviewStore: ReviewStore) : ReviewService {

    override fun createReview(): Review {
        TODO("Not yet implemented")
    }

    override fun updateReview() {
        TODO("Not yet implemented")
    }

    override fun deleteReview() {
        TODO("Not yet implemented")
    }

    override fun getReviews() {
        TODO("Not yet implemented")
    }

    override fun getReview() {
        TODO("Not yet implemented")
    }
}