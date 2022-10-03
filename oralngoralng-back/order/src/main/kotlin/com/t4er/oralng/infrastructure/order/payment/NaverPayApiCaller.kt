package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.domain.order.payment.PayMethod
import org.springframework.stereotype.Component

@Component
class NaverPayApiCaller:PaymentApiCaller {

    override fun support(payMethod: PayMethod): Boolean {
        return PayMethod.NAVER_PAY == payMethod
    }

    override fun pay(command: OrderCommand.PaymentRequest) {
        TODO("Not yet implemented")
    }
}