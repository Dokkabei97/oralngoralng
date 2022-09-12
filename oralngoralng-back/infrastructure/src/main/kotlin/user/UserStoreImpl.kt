package user

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