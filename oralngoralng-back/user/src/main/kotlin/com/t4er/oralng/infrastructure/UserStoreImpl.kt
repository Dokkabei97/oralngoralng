package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.User
import com.t4er.oralng.domain.UserStore
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(val userRepository: UserRepository) : UserStore {

    override fun store(user: User): User = userRepository.save(user)


    override fun delete(id: Long) = userRepository.deleteById(id)

}