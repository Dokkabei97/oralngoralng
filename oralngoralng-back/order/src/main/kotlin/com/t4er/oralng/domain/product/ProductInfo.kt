package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.membership.Membership

class ProductInfo (
    var membershipName: Membership.MembershipName,

    var name: String,

    var price: Int,

    var duration: String
)