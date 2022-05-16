package com.t4er.oralng.user.domain

interface UserStore {

    fun store(user: User): User
    fun delete(id: Long)
}