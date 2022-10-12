package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.infrastructure.order.OrderRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class OrderServiceImplTest : BehaviorSpec({
    val orderService = mockk<OrderService>(relaxed = true)

    given("Order 서비스") {
        val registerOrderRequest = mockk<RegisterOrderRequest>()
        val orderInfo = mockk<OrderInfo>()
        `when`("registerOrder가 호출") {
            every { orderService.registerOrder(any()) } returns orderInfo
            orderService.registerOrder(registerOrderRequest)
            then("registerOrder는 호출 됨") {
                verify { orderService.registerOrder(any()) }
            }
        }
    }
})