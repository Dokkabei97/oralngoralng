package com.t4er.oralng.application.order

import com.t4er.oralng.domain.order.OrderCommand
import com.t4er.oralng.domain.order.OrderInfo
import com.t4er.oralng.domain.order.OrderService
import org.springframework.stereotype.Service

@Service
class OrderFacade(val orderService: OrderService) {

    fun registerOrder(command: OrderCommand.RegisterOrderRequest): OrderInfo {
        return orderService.registerOrder(command)
    }
}