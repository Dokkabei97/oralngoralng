package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.payment.PaymentProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderServiceImpl(
    val orderReader: OrderReader,
    val orderStore: OrderStore,
    val paymentProcess: PaymentProcessor,
) : OrderService {

    @Transactional
    override fun registerOrder(command: RegisterOrderRequest): OrderInfo {
        val order = orderStore.store(
            Order.of(command.user, command.productId, command.price, command.payMethod)
        )
        return OrderInfo(order)
    }

    @Transactional
    override fun paymentOrder(command: PaymentRequest) {
        val order = orderReader.getOrder(command.orderToken)
        try {
            paymentProcess.pay(order, command)
            order.orderSuccess()
        } catch (exception: Exception) {
            order.orderFail()
        }
    }
}