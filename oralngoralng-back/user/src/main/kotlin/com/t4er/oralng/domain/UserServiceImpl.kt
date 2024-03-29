package com.t4er.oralng.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.t4er.oralng.domain.UserCommand.*

@Service
@Transactional(readOnly = true)
class UserServiceImpl(val userReader: UserReader, val userStore: UserStore): UserService {

    @Transactional
    override fun registerUser(command: RegisterUserRequest): UserInfo {
        val user = userStore.store(User.of(command.nickname, command.email))
        return UserInfo(user)
    }

    @Transactional
    override fun updateUser(command: UpdateUserRequest): UserInfo {
        val user = userReader.getUser(command.userId)
        user.updateNickname(command.nickname)
        return UserInfo(user)
    }

    @Transactional
    override fun deleteUser(command: DeleteUserRequest) {
        val user = userReader.getUser(command.userId)
        user.id?.let { userStore.delete(it) }
    }

    override fun getUser(command: GetUserRequest): UserInfo {
        val user = userReader.getUser(command.userId)
        return UserInfo(user)
    }
}