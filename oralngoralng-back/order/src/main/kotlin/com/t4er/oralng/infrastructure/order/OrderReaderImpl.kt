package com.t4er.oralng.infrastructure.order

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderReader
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OrderReaderImpl(val orderRepository: OrderRepository): OrderReader {

    override fun getOrder(orderToken: String): Order {
        return orderRepository.findByOrderToken(orderToken)
    }

    override fun getOrders(userId: Long): List<Order> {
        return orderRepository.findAllByUserId(userId)
    }
}