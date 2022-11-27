package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod
import jakarta.validation.constraints.NotBlank

class OrderCommand {

    class RegisterOrderRequest(
        val userId: Long,
        val productId: Long,
        val price: Int,
        val payMethod: PayMethod,
    )

    class PaymentRequest(
        @field: NotBlank(message = "orderToken 은 필수 입니다.")
        val orderToken: String,
        val price: Int,
        val payMethod: PayMethod,
    )

    class GetOrdersRequest(
        val userId: Long,
    )

    class GetOrderRequest(
        @field: NotBlank(message = "orderToken 은 필수 입니다.")
        val orderToken: String,
    )
}