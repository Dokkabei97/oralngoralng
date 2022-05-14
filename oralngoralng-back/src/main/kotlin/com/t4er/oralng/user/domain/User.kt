package com.t4er.oralng.user.domain

import javax.persistence.*

@Entity
class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "user_token", nullable = false, updatable = false)
    var userToken: String,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "email")
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: Status
) {
    enum class Status(val description: String) {
        COMMON("일반 회원"),
        MEMBERSHIP1("멤버쉽1 회원"),
        MEMBERSHIP2("멤버쉽2 회원"),
        ADMIN("관리자")
    }


}