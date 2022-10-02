package com.t4er.oralng.domain.order.payment.validator

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.exception.InvalidParamException

@org.springframework.core.annotation.Order(value = 2)
class PayMethodValidator: PaymentValidator {

    override fun validate(order: Order, command: OrderCommand.PaymentRequest) {
        if (order.payMethod != command.payMethod) throw InvalidParamException("주문 과정에서의 결제수단이 다릅니다")
    }
}