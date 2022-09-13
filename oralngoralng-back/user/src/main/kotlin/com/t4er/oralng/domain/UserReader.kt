package com.t4er.oralng.domain

interface UserReader {
    fun getUser(id: Long): User
}