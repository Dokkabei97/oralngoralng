package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod
import io.kotest.core.spec.style.AnnotationSpec
import org.springframework.graphql.test.tester.GraphQlTester

internal class OrderGraphqlTest : AnnotationSpec() {

    private lateinit var graphqlTest: GraphQlTester

    init {
        @Test
        fun register_order_success() {
            // given
            val variable: Map<String, Any> = mapOf(
                Pair("userId", 1L),
                Pair("productId", 1L),
                Pair("price", 5000),
                Pair("payMethod", PayMethod.NAVER_PAY),
            )

            // when then
            graphqlTest.document("registerOrder")
                .variable("input", variable)
                .execute()
                .path("registerOrder.userId")
                .entity(Long::class.java)
                .isEqualTo(1L)
                .path("registerOrder.orderStatus")
                .entity(Order.OrderStatus::class.java)
                .isEqualTo(Order.OrderStatus.INIT)
        }
    }

}
