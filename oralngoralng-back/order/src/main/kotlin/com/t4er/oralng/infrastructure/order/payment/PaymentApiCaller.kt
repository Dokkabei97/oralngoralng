package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.domain.order.payment.PayMethod

interface PaymentApiCaller {

    fun support(payMethod: PayMethod): Boolean

    fun pay(command: OrderCommand.PaymentRequest)
}