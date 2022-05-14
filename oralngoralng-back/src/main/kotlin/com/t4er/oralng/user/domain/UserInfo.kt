package com.t4er.oralng.user.domain

class UserInfo(user: User) {
    var userToken: String = user.userToken
    var nickname: String = user.nickname
    var email: String = user.email
    var status: User.Status = user.status
}