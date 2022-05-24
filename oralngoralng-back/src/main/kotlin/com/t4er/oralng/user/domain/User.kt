package com.t4er.oralng.user.domain

import com.t4er.oralng.common.entity.AbstractEntity
import com.t4er.oralng.common.exception.InvalidParamException
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long?,

    @Column(name = "nickname", nullable = false)
    var nickname: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: Status,
) : AbstractEntity() {

    enum class Status(val description: String) {
        COMMON("일반 회원"),
        MEMBERSHIP1("멤버쉽1 회원"),
        MEMBERSHIP2("멤버쉽2 회원"),
        ADMIN("관리자")
    }

    companion object {
        fun of(nickname: String, email: String): User {
            if (isValid(nickname)) throw InvalidParamException("닉네임은 12글자 이하만 사용 가능합니다.")
            return User(null, nickname, email, Status.COMMON)
        }
    }

    fun updateNickname(nickname: String) {
        this.nickname = nickname
    }

    fun updateStatus(status: Status) {
        this.status = status
    }
}

private fun isValid(nickname: String): Boolean {
    return nickname.length > 12
}
