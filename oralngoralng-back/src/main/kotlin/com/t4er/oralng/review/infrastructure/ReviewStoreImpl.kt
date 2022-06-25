package com.t4er.oralng.review.infrastructure

import com.t4er.oralng.review.domain.ReviewReader
import org.springframework.stereotype.Component

@Component
class ReviewStoreImpl(val reviewRepository: ReviewRepository): ReviewReader {
}