package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.OrderCommand.PaymentRequest
import com.t4er.oralng.domain.order.payment.PayMethod

class KakaoPayApiCaller : PaymentApiCaller {

    override fun support(payMethod: PayMethod): Boolean = PayMethod.KAKAO_PAY == payMethod

    override fun pay(command: PaymentRequest) {
        TODO("Not yet implemented")
    }
}