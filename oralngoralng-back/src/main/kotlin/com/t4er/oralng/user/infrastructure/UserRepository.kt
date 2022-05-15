package com.t4er.oralng.user.infrastructure

import com.t4er.oralng.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUserToken(userToken: String): User
}