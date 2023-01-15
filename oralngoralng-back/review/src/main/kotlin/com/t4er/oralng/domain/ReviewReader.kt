package com.t4er.oralng.domain

interface ReviewReader {
    fun getReview(reviewId: Long): Review
}