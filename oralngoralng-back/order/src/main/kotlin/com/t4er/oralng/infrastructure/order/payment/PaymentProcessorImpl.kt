package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.domain.order.payment.PaymentProcessor
import com.t4er.oralng.domain.order.payment.validator.PaymentValidator
import com.t4er.oralng.exception.InvalidParamException
import org.springframework.stereotype.Component

@Component
class PaymentProcessorImpl(
    val paymentValidators: List<PaymentValidator>,
    val paymentApiCallers: List<PaymentApiCaller>,
) : PaymentProcessor {

    override fun pay(order: Order, command: OrderCommand.PaymentRequest) {
        paymentValidators.forEach { paymentValidator -> paymentValidator.validate(order, command) }
        val paymentApiCaller = routingApiCaller(command)
        paymentApiCaller.pay(command)
    }

    private fun routingApiCaller(command: OrderCommand.PaymentRequest): PaymentApiCaller {
        return paymentApiCallers.stream()
            .filter{ paymentApiCaller -> paymentApiCaller.support(command.payMethod) }
            .findFirst()
            .orElseThrow{ InvalidParamException() }
    }
}