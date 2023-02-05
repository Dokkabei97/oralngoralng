package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import com.t4er.oralng.domain.ReviewReader
import com.t4er.oralng.exception.EntityNotFoundException
import org.springframework.stereotype.Component

@Component
class ReviewReaderImpl(val reviewRepository: ReviewRepository) : ReviewReader {
    override fun getReview(reviewId: Long): Review =
        reviewRepository.findById(reviewId).orElseThrow { EntityNotFoundException("해당 게시글은 없습니다.") }

}