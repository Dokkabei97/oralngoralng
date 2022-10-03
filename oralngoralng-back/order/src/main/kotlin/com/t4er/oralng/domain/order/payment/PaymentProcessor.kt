package com.t4er.oralng.domain.order.payment

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand

interface PaymentProcessor {
    fun pay(order: Order, command: OrderCommand.PaymentRequest)
}