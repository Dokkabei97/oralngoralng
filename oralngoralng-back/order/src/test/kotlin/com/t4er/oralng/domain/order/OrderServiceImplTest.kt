package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.OrderCommand.RegisterOrderRequest
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class OrderServiceImplTest : BehaviorSpec({
    given("Order 서비스") {
        val orderCommand = mockk<RegisterOrderRequest>()
        val orderInfo = mockk<OrderInfo>()
        val orderService = mockk<OrderService>()

        `when`("registerOrder가 호출") {
            every { orderService.registerOrder(any()) } returns orderInfo
            orderService.registerOrder(orderCommand)
            then("registerOrder는 호출 됨") {
                verify { orderService.registerOrder(any()) }
            }
        }

    }

})
