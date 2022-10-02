package com.t4er.oralng.domain.order.payment.validator

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.exception.InvalidParamException

@org.springframework.core.annotation.Order(value = 1)
class PayAmountValidator: PaymentValidator {

    override fun validate(order: Order, command: OrderCommand.PaymentRequest) {
        if (order.price != command.price) throw InvalidParamException("주문 가격이 불일치 합니다")
    }
}