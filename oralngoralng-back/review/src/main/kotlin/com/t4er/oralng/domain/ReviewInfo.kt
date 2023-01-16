package com.t4er.oralng.domain

class ReviewInfo(review: Review) {
    val reviewId: Long? = review.id
    val userId: Long = review.userId
    val nickname: String = review.nickname
    val title: String = review.title
    val content: String = review.content
    val image: MutableList<Image>? = review.images
    val locationTags: String = review.locationTags
    val themeTags: String = review.themeTags
    val commentCount: Int = review.commentCount
    val recommendCount: Int = review.recommendCount
    val reportCount: Int = review.reportCount
}