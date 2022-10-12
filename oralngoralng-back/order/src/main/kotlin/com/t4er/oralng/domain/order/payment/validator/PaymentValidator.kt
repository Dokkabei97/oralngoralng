package com.t4er.oralng.domain.order.payment.validator

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand

interface PaymentValidator {
    fun validate(order: Order, command: OrderCommand.PaymentRequest)
}