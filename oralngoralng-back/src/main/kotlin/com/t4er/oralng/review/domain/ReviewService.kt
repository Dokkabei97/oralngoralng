package com.t4er.oralng.review.domain

interface ReviewService {
    fun createReview(): Review
    fun updateReview()
    fun deleteReview()
    fun getReviews()
    fun getReview()
}