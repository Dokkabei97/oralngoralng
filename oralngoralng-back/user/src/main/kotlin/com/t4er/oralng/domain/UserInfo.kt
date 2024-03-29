package com.t4er.oralng.domain

class UserInfo(user: User) {
    var userId: Long? = user.id
    var nickname: String = user.nickname
    var email: String = user.email
    var status: User.Status = user.status
}