package com.t4er.oralng.review.infrastructure

import com.t4er.oralng.review.domain.ReviewReader
import com.t4er.oralng.review.domain.ReviewStore
import org.springframework.stereotype.Component

@Component
class ReviewReaderImpl(val reviewRepository: ReviewRepository): ReviewStore {
}