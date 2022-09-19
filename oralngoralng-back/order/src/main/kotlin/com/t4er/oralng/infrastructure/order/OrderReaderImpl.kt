package com.t4er.oralng.infrastructure.order

import com.t4er.oralng.domain.order.OrderReader
import org.springframework.stereotype.Component

@Component
class OrderReaderImpl(val orderRepository: OrderRepository): OrderReader {
}