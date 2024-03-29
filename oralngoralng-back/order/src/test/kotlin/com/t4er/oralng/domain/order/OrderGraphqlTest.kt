package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.response.ErrorType
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
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

        @Test
        fun register_order_fail() {
            // given
            val variable: Map<String, Any> = mapOf(
                Pair("userId", "ABC"),
                Pair("productId", 1L),
                Pair("price", "ABC"),
                Pair("payMethod", PayMethod.NAVER_PAY),
            )

            // when then
            graphqlTest.document("registerOrder")
                .variable("input", variable)
                .execute()
                .errors()
                .satisfy {
                    error -> error.get(0).errorType shouldBe ErrorType.InvalidParam
                }

            @Test
            fun payment_order_success() {
                val variable: Map<String, Any> = mapOf(
                        Pair("orderToken", "")
                )
            }
        }
    }

}
