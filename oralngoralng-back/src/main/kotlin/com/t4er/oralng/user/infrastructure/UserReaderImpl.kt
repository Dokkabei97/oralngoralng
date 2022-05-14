package com.t4er.oralng.user.infrastructure

import com.t4er.oralng.user.domain.User
import com.t4er.oralng.user.domain.UserReader
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(val userRepository: UserRepository): UserReader {

    override fun getUser(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow()
        // TODO: 2022-05-15 orElseThrow 정의
    }

    override fun getUser(userToken: String): User {
        return userRepository.findByUserToken(userToken)
    }
}