package com.t4er.oralng.domain.product

import com.t4er.oralng.domain.membership.Membership

class ProductCommand {

    class RegisterProductRequest(
        var membershipName: Membership.MembershipName,
        var name: String,
        var price: Int,
        var duration: String
    )
}