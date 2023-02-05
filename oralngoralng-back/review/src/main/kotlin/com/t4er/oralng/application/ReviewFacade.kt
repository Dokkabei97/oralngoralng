package com.t4er.oralng.application

import com.t4er.oralng.domain.ReviewCommand.*
import com.t4er.oralng.domain.ReviewInfo
import com.t4er.oralng.domain.ReviewService
import org.springframework.stereotype.Service

@Service
class ReviewFacade(val reviewService: ReviewService) {

    fun createReview(command: CreateReviewRequest): ReviewInfo = reviewService.create(command)
    fun updateReview(command: UpdateReviewRequest): ReviewInfo = reviewService.update(command)

}