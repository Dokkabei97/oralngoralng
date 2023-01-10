package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.ReviewReader
import org.springframework.stereotype.Component

@Component
class ReviewReaderImpl(val reviewRepository: ReviewRepository): ReviewReader {
}