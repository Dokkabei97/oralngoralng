package com.t4er.oralng.domain.order

class OrderCommand {

    class RegisterOrderRequest (
        var user: Long,
        var productId: Long,
        var price: Int
    )
}