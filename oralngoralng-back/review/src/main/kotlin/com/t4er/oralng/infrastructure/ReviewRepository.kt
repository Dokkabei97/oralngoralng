package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ReviewRepository : JpaRepository<Review, Long> {
    @Modifying
    @Query("delete from Review r where r.id = :id")
    fun deleteReview(@Param("id") id: Long)
}