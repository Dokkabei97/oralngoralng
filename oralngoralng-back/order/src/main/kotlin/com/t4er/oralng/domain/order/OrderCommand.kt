package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod

class OrderCommand {

    class RegisterOrderRequest(
        var userId: Long,
        var productId: Long,
        var price: Int,
        var payMethod: PayMethod
    )

    class PaymentRequest(
        var orderToken: String,
        var price: Int,
        var payMethod: PayMethod
    )

    class GetOrdersRequest(
        var userId: Long
    )

    class GetOrderRequest(
        var orderToken: String
    )
}