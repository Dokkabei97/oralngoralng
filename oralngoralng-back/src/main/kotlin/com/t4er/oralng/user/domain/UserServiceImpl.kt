package com.t4er.oralng.user.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserServiceImpl(val userReader: UserReader, val userStore: UserStore): UserService {

    @Transactional
    override fun createUser(command: UserCommand.RegisterUserRequest): UserInfo {
        val toEntity = UserCommand.RegisterUserRequest.toEntity(command.nickname, command.email)
        val user = userStore.store(toEntity)
        return UserInfo(user)
    }

    @Transactional
    override fun updateUser(command: UserCommand.UpdateUserRequest): UserInfo {
        val user = userReader.getUser(command.userId)
        user.updateNickname(command.nickname)
        return UserInfo(user)
    }

    @Transactional
    override fun deleteUser(command: UserCommand.DeleteUserRequest) {
        val user = userReader.getUser(command.userId)
        user.id?.let { userStore.delete(it) }
    }

    override fun getUser(command: UserCommand.GetUserRequest): UserInfo {
        val user = userReader.getUser(command.userId)
        return UserInfo(user)
    }
}