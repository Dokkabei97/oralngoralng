package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository: JpaRepository<Admin, Long> {
}