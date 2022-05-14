package com.t4er.oralng.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User (

    @Id
    @GeneratedValue
    var id: Long,

    @Column(name = "user_token", nullable = false, updatable = false)
    var userToken: String,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "email")
    var email: String,
)