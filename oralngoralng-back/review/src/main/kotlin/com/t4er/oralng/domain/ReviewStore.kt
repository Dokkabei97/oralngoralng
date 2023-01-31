package com.t4er.oralng.domain


interface ReviewStore {
    fun create(review: Review): Review
    fun delete(reviewId: Long)
}