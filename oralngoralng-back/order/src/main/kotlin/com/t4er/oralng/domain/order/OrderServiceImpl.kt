package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderServiceImpl(val orderReader: OrderReader, val orderStore: OrderStore) : OrderService {

    @Transactional
    override fun registerOrder(command: RegisterOrderRequest): OrderInfo {
        val order = orderStore.store(Order.of(command.user, command.productId, command.price))
        return OrderInfo(order)
    }
}