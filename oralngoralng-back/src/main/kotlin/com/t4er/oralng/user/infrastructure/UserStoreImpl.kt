package com.t4er.oralng.user.infrastructure

import com.t4er.oralng.user.domain.User
import com.t4er.oralng.user.domain.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(val userRepository: UserRepository): UserStore {

    override fun store(user: User): User {
        validCheck(user)
        return userRepository.save(user)
    }

    // TODO: 2022-05-15 예외 정의
    fun validCheck(user: User) {
        if (user.userToken == null) throw RuntimeException()
    }
}