package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}