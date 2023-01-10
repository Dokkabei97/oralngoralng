package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
}