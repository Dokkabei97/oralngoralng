package com.t4er.oralng.domain.order

interface OrderReader {
    fun getOrder(orderToken: String): Order
    fun getOrders(userId: Long): List<Order>
}