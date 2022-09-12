package com.t4er.oralng.user

import com.t4er.oralng.user.User
import com.t4er.oralng.user.UserReader
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class UserReaderImpl(val userRepository: UserRepository): UserReader {

    override fun getUser(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { RuntimeException("해당 유저는 없습니다.") }
    }
}