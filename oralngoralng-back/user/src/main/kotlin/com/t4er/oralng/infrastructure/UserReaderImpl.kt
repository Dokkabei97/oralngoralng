package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.User
import com.t4er.oralng.domain.UserReader
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(val userRepository: UserRepository): UserReader {

    override fun getUser(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { RuntimeException("해당 유저는 없습니다.") }
    }
}