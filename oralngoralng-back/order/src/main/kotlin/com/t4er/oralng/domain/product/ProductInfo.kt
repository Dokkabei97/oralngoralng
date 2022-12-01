package com.t4er.oralng.domain.product

class ProductInfo(product: Product) {
    var name: String = product.name
    var price: Int = product.price
    var duration: String = product.duration
    var membershipName: Product.MembershipName = product.membershipName
}