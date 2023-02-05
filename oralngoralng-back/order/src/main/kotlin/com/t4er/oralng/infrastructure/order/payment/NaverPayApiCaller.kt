package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.OrderCommand.PaymentRequest
import com.t4er.oralng.domain.order.payment.PayMethod
import org.springframework.stereotype.Component

@Component
class NaverPayApiCaller : PaymentApiCaller {

    override fun support(payMethod: PayMethod): Boolean = PayMethod.NAVER_PAY == payMethod

    override fun pay(command: PaymentRequest) {
        println("네이버 결제")
    }
}