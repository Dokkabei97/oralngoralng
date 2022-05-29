package com.t4er.oralng.user.infrastructure

import com.t4er.oralng.common.exception.EntityNotFoundException
import com.t4er.oralng.user.domain.User
import com.t4er.oralng.user.domain.UserReader
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(val userRepository: UserRepository): UserReader {

    override fun getUser(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("해당 유저는 없습니다.") }
    }
}