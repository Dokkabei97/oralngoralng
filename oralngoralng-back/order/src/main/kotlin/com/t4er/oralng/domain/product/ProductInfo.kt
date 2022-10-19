package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.membership.Membership

class ProductInfo(product: Product) {
    var membership: Membership.MembershipName = product.membershipName
    var name: String = product.name
    var price: Int = product.price
    var duration: String = product.duration
}