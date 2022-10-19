package com.t4er.oralng.`interface`.order

import com.t4er.oralng.application.order.OrderFacade
import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.OrderInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderBackController(val orderFacade: OrderFacade) {

    @GetMapping("/{userId}")
    fun getOrders(@PathVariable userId: Long): List<OrderInfo> {
        return orderFacade.getOrders(GetOrdersRequest(userId))
    }
}