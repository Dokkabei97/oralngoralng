package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.CommonEntity
import com.t4er.oralng.domain.order.OrderCommand.*
import com.t4er.oralng.domain.order.payment.PayMethod
import com.t4er.oralng.exception.InvalidParamException
import com.t4er.oralng.infrastructure.order.OrderRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import io.kotest.extensions.spring.SpringExtension

@SpringBootTest
internal class OrderPaymentTest: BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var orderService: OrderService

    @Autowired
    private lateinit var orderRepository: OrderRepository

    init {
        given("주문 테스트") {
            val orderRequest = RegisterOrderRequest(1L, 1L, 5000, PayMethod.NAVER_PAY)
            val orderInfo = orderService.registerOrder(orderRequest)

            `when`("주문 성공") {
                val paymentRequest = PaymentRequest(orderInfo.orderToken, 5000, PayMethod.NAVER_PAY)
                orderService.paymentOrder(paymentRequest)

                val order = orderRepository.findByOrderToken(orderInfo.orderToken)
                then("성공") {
                    order.orderStatus shouldBe Order.OrderStatus.ORDER_COMPLETE
                    order.commonEntity!!.resultStatus shouldBe CommonEntity.ResultStatus.SUCCESS
                    order.commonEntity!!.resultMessage shouldBe "주문 성공"
                }
            }

            `when`("주문 실패 결제 메서드 틀림") {
                val paymentRequest = PaymentRequest(orderInfo.orderToken, 5000, PayMethod.KAKAO_PAY)
                orderService.paymentOrder(paymentRequest)

                val order = orderRepository.findByOrderToken(orderInfo.orderToken)
                then("실패") {
                    order.commonEntity!!.resultStatus shouldBe CommonEntity.ResultStatus.FAIL
                    order.commonEntity!!.resultMessage shouldBe "주문 실패"
                }
            }
        }
    }
}
