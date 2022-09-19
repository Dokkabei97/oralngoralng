package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.*

interface OrderService {
    fun registerOrder(command: RegisterOrderRequest): OrderInfo
}