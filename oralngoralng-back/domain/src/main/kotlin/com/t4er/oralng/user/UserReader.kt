package com.t4er.oralng.user

interface UserReader {
    fun getUser(id: Long): User
}