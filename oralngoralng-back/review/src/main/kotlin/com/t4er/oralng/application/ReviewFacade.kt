package com.t4er.oralng.application

import com.t4er.oralng.domain.ReviewService
import org.springframework.stereotype.Service

@Service
class ReviewFacade(val reviewService: ReviewService) {
}