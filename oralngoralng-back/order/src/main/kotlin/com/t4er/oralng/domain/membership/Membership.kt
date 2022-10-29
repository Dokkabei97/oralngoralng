package com.t4er.oralng.domain.membership

import javax.persistence.*

@Entity
@Table(name = "memberships")
class Membership(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id")
    var id: Long?,

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    var name: MembershipName,

    @Column(name = "description")
    var description: String,
) {
    enum class MembershipName(description: String) {
        BASIC("베이직 등급"),
        STANDARD("스탠다드 등급"),
        PREMIUM("프리미엄 등급")
    }
}