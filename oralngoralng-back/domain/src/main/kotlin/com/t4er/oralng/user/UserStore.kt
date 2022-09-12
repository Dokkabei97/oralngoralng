package com.t4er.oralng.user


interface UserStore {
    fun store(user: User): User
    fun delete(id: Long)
}