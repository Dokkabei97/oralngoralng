package com.t4er.oralng.user.domain

interface UserReader {
    fun getUser(id: Long): User
    fun getUser(userToken: String): User
}