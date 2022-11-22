package com.t4er.oralng.domain.product


class ProductCommand {

    class RegisterProductRequest(
        var name: String,
        var price: Int,
        var duration: String,
        var membershipName: Product.MembershipName
    )
}