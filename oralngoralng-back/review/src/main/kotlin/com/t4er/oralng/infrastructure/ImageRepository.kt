package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository : JpaRepository<Image, Long> {
}