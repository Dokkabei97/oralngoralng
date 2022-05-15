package com.t4er.oralng.user.domain

import com.t4er.oralng.common.entity.AbstractEntity
import com.t4er.oralng.common.utils.TokenGenerator
import javax.persistence.*

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long?,

    @Column(name = "user_token", nullable = false, updatable = false)
    var userToken: String,

    @Column(name = "nickname", nullable =  false)
    var nickname: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: Status

): AbstractEntity() {
    enum class Status(val description: String) {
        COMMON("일반 회원"),
        MEMBERSHIP1("멤버쉽1 회원"),
        MEMBERSHIP2("멤버쉽2 회원"),
        ADMIN("관리자")
    }
    companion object {
        private const val USER_PREFIX = "usr_"
        fun of(nickname: String, email: String): User {
            return User(null, TokenGenerator.randomCharacterWithPrefix(USER_PREFIX), nickname, email, Status.COMMON)
        }
    }
}