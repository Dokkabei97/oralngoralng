package com.t4er.oralng.domain.other

import com.t4er.oralng.entity.AbstractEntity
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
        BASIC("베이직 회원"),
        STANDARD("스탠다드 회원"),
        PREMIUM("프리미엄 회원"),
        ADMIN("관리자")
    }
}