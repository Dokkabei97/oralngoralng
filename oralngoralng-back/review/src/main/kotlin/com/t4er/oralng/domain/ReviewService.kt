package com.t4er.oralng.domain

import com.t4er.oralng.domain.ReviewCommand.*

interface ReviewService {
    fun create(command: CreateReviewRequest): ReviewInfo
    fun update(command: UpdateReviewRequest): ReviewInfo
    fun delete(command: DeleteReviewRequest)
}