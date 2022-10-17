package com.t4er.oralng.domain.order

import com.t4er.oralng.domain.order.payment.PayMethod
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import java.time.ZoneId
import java.time.ZonedDateTime

internal class OrderTest : DescribeSpec({

    describe("주문") {
        val orderDate1: ZonedDateTime = ZonedDateTime.of(
            2022,
            3,
            15,
            12,
            0,
            0,
            0,
            ZoneId.of("Asia/Seoul")
        )
        val orderDate2: ZonedDateTime = ZonedDateTime.of(
            2022,
            11,
            15,
            12,
            0,
            0,
            0,
            ZoneId.of("Asia/Seoul")
        )
        context("만료일 검증") {
            val expirationProductAt: ZonedDateTime = orderDate1.plusMonths(3)
            expirationProductAt.plusMonths(3)
            it("성공") {
                expirationProductAt shouldBe ZonedDateTime.of(
                    2022,
                    6,
                    15,
                    12,
                    0,
                    0,
                    0,
                    ZoneId.of("Asia/Seoul")
                )
            }
        }
        context("11월에 6개월 짜리 상품 주문시") {
            val expirationProductAt: ZonedDateTime = orderDate2.plusMonths(6)
            it("성공") {
                expirationProductAt shouldBe ZonedDateTime.of(
                    2023,
                    5,
                    15,
                    12,
                    0,
                    0,
                    0,
                    ZoneId.of("Asia/Seoul")
                )
            }
        }
        context("주문 생성") {
            val order: Order = Order.of(1L, 1L, 5000, PayMethod.NAVER_PAY)
            it("성공") {
                order.userId shouldBe 1L
                order.orderToken shouldStartWith "ord_"
            }
        }
    }
})
