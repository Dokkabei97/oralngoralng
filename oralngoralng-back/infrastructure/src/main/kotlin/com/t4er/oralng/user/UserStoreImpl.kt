package com.t4er.oralng.user

import com.t4er.oralng.user.User
import com.t4er.oralng.user.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(val userRepository: UserRepository) : UserStore {

    override fun store(user: User): User {
        return userRepository.save(user)
    }

    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }
}