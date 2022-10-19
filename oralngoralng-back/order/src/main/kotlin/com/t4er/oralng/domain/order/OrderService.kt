package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.*

interface OrderService {
    fun registerOrder(command: RegisterOrderRequest): OrderInfo

    fun paymentOrder(command: PaymentRequest)

    fun getOrders(command: GetOrdersRequest): List<OrderInfo>
    fun getOrder(command: GetOrderRequest): OrderInfo
}