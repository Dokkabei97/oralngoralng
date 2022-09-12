package com.t4er.oralng.user

import com.t4er.oralng.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}