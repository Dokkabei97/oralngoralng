package com.t4er.oralng.`interface`.order

import com.t4er.oralng.application.order.OrderFacade
import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.OrderInfo
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import jakarta.validation.Valid

@Controller
class OrderController(val orderFacade: OrderFacade) {

    @MutationMapping
    fun registerOrder(@Argument @Valid input: RegisterOrderRequest): OrderInfo {
        return orderFacade.registerOrder(input)
    }

    @MutationMapping
    fun paymentOrder(@Argument @Valid input: PaymentRequest) {
        orderFacade.paymentOrder(input)
    }

    @QueryMapping
    fun getOrders(@Argument @Valid input: GetOrdersRequest): List<OrderInfo> {
        return orderFacade.getOrders(input)
    }

    @QueryMapping
    fun getOrder(@Argument @Valid input: GetOrderRequest): OrderInfo {
        return orderFacade.getOrder(input)
    }
}