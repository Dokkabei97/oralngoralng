package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*

interface ReviewService {
    fun create(review: CreateReviewRequest)
    fun update(review: UpdateReviewRequest)
    fun delete(review: DeleteReviewRequest)
}