package com.t4er.oralng.domain.order.payment.validator

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.exception.InvalidParamException

@org.springframework.core.annotation.Order(value = 3)
class PayStatusValidator: PaymentValidator {

    override fun validate(order: Order, command: OrderCommand.PaymentRequest) {
        if (order.isAlreadyPaymentComplete()) throw InvalidParamException("이미 결제완료된 주문입니다")
    }
}