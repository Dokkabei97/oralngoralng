package com.t4er.oralng.infrastructure.order

import com.t4er.oralng.domain.order.Order
import com.t4er.oralng.domain.order.OrderStore
import org.springframework.stereotype.Component

@Component
class OrderStoreImpl(val orderRepository: OrderRepository) : OrderStore {

    override fun store(order: Order): Order = orderRepository.save(order)
}