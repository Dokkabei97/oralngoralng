package com.t4er.oralng.user.domain

class UserInfo(user: User) {
    var nickname: String = user.nickname
    var email: String = user.email
    var status: User.Status = user.status
}