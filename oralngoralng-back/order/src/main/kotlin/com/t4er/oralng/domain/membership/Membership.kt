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

    @Column(name = "price")
    var price: Int,
) {
    enum class MembershipName(description: String, price: Int) {
        BASIC("베이직 등급", 5000),
        STANDARD("스탠다드 등급", 7500),
        PREMIUM("프리미엄 등급", 10000)
    }
}