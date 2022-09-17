package com.t4er.oralng.infrastructure.order

import com.t4er.oralng.domain.order.OrderStore
import org.springframework.stereotype.Component

@Component
class OrderStoreImpl(val orderRepository: OrderRepository): OrderStore {
}