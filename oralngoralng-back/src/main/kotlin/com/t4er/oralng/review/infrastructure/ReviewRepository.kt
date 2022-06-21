package com.t4er.oralng.review.infrastructure

import com.t4er.oralng.review.domain.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
}