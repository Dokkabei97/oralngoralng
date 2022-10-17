package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.membership.Membership
import com.t4er.oralng.domain.membership.Membership.*
import com.t4er.oralng.entity.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "products")
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var id: Long?,

    @Column(name = "membership_name")
    var membershipName: MembershipName,

    @Column(name = "name")
    var name: String,

    @Column(name = "price")
    var price: Int,

    @Column(name = "duration")
    var duration: String,
) : AbstractEntity() {

    companion object {
        fun of(membershipName: MembershipName, name: String, price: Int, duration: String): Product {
            return Product(null, membershipName, name, price, duration)
        }
    }
}
