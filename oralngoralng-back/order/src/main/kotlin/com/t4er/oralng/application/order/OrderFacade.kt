package com.t4er.oralng.application.order

import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.OrderInfo
import com.t4er.oralng.domain.order.OrderService
import org.springframework.stereotype.Service

@Service
class OrderFacade(val orderService: OrderService) {

    fun registerOrder(command: RegisterOrderRequest): OrderInfo = orderService.registerOrder(command)
    fun paymentOrder(command: PaymentRequest) = orderService.paymentOrder(command)
    fun getOrders(command: GetOrdersRequest): List<OrderInfo> = orderService.getOrders(command)
    fun getOrder(command: GetOrderRequest): OrderInfo = orderService.getOrder(command)

}