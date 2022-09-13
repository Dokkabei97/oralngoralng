package com.t4er.oralng.domain

interface UserStore {
    fun store(user: User): User
    fun delete(id: Long)
}