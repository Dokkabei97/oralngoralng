package com.t4er.oralng.infrastructure.order.payment

import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.domain.order.payment.PayMethod

class KakaoPayApiCaller: PaymentApiCaller {

    override fun support(payMethod: PayMethod): Boolean {
        return PayMethod.KAKAO_PAY == payMethod
    }

    override fun pay(command: OrderCommand.PaymentRequest) {
        TODO("Not yet implemented")
    }
}