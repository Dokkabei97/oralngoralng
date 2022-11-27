package com.t4er.oralng.domain.product

import com.t4er.oralng.entity.AbstractEntity
import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "price")
    var price: Int,

    @Column(name = "duration")
    var duration: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_name")
    var membershipName: MembershipName,
) : AbstractEntity() {

    enum class MembershipName {
        BASIC,
        STANDARD,
        PREMIUM
    }

    companion object {
        fun of(name: String, price: Int, duration: String, membershipName: MembershipName): Product {
            return Product(null, name, price, duration, membershipName)
        }
    }
}
