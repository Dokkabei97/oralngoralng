package com.t4er.oralng.user.infrastructure

import com.t4er.oralng.user.domain.User
import com.t4er.oralng.user.domain.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(val userRepository: UserRepository): UserStore {

    override fun store(user: User): User {
        return userRepository.save(user)
    }

}